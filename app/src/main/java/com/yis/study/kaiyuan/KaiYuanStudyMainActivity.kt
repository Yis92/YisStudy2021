package com.yis.study.kaiyuan

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.yis.study.R
import com.yis.study.kaiyuan.eventbus.EventBusStudyActivity
import com.yis.study.path.StudyRouterPath
import kotlinx.android.synthetic.main.activity_kaiyuan_study_main.*

/**
 * 第三方开源库学习列表
 * Created by liuyi on 2021-03-24.
 */
class KaiYuanStudyMainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kaiyuan_study_main)

        btnEventBus.setOnClickListener {
            startActivity(Intent(this, EventBusStudyActivity::class.java))
        }

        btnArouter.setOnClickListener {
            ARouter.getInstance().build(StudyRouterPath.STUDY_ROUTER_PATH)
                .withString("name", "123")
                .navigation()
        }
    }
}