package com.yis.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yis.study.activity.MyActivity
import com.yis.study.annotation.AnnotationActivity
import com.yis.study.handler.MyHandlerThread
import com.yis.study.http.HttpActivity
import com.yis.study.proxy.ProxyActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnProxy.setOnClickListener {
            startActivity(Intent(this, ProxyActivity::class.java))
        }

        btnAnnotation.setOnClickListener {
            startActivity(Intent(this, AnnotationActivity::class.java))
        }

        btnRetrofit.setOnClickListener {
            startActivity(Intent(this, HttpActivity::class.java))
        }

        btnHandlerThread.setOnClickListener {
            startActivity(Intent(this, MyHandlerThread::class.java))
        }

        btnActivity.setOnClickListener {
            startActivity(Intent(this, MyActivity::class.java))
        }
    }
}
