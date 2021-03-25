package com.yis.study.kaiyuan

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.yis.study.R
import com.yis.study.kaiyuan.eventbus.EventBusStudyActivity
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
    }
}