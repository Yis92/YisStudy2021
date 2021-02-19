package com.yis.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yis.study.annotation.AnnotationActivity
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
    }
}
