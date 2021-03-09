package com.yis.study.xingneng.oom;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import com.yis.study.R;
import com.yis.study.base.BaseActivity;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuyi on 2021-03-08.
 */
public class MatUseActivity extends BaseActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    WeakReference<Activity> weakReference;

    MyThread thread;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mat_use;
    }

    @Override
    protected void initData() {
        weakReference = new WeakReference<Activity>(this);
        verifyStoragePermissions(this);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000 * 30);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                createDumpFile(weakReference.get());
//            }
//        }).start();

        thread = new MyThread();
        thread.start();
    }


    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean createDumpFile(Context context) {
        Log.i("Zero", "开始dump...");
        String LOG_PATH = "/dump.gc/";
        boolean bool = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ssss");
        String createTime = sdf.format(new Date(System.currentTimeMillis()));
        String state = android.os.Environment.getExternalStorageState();
        // 判断SdCard是否存在并且是可用的
        if (android.os.Environment.MEDIA_MOUNTED.equals(state)) {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + LOG_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            String hprofPath = file.getAbsolutePath();
            if (!hprofPath.endsWith("/")) {
                hprofPath += "/";
            }

            hprofPath += createTime + ".hprof";
            try {
                android.os.Debug.dumpHprofData(hprofPath);
                bool = true;
                Log.d("ANDROID_LAB", "create dumpfile done!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            bool = false;
            Log.d("ANDROID_LAB", "nosdcard!");
        }

        return bool;
    }

    static class MyThread extends Thread {

        private boolean mRunning = false;

        @Override
        public void run() {
            mRunning = true;
            if (mRunning) {
                // 不要以为Java永远会帮你清理回收正在运行的threads。在上面的代码中，
                // 我们很容易误以为当Activity结束销毁时会帮我们把正在运行的thread也结束回收掉，
                // 但事情永远不是这样的！Java threads会一直存在，只有当线程运行完成或被杀死掉，
                // 线程才会被回收。所以我们应该养成为thread设置退出逻辑条件的习惯。
                SystemClock.sleep(10000);
            }
        }

        void close(){
            mRunning = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.close();
    }
}
