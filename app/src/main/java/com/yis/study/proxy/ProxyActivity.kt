package com.yis.study.proxy

import android.app.Activity
import android.os.Bundle
import com.yis.study.proxy.dong.*
import com.yis.study.proxy.jin.ProxyImpl
import com.yis.study.proxy.jin.TargetFactoryServiceImpl
import kotlinx.android.synthetic.main.activity_proxy.*

/**
 * Created by liuyi on 2021-02-09.
 */
class ProxyActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.yis.study.R.layout.activity_proxy)

        btnJintai.setOnClickListener {
            val service = TargetFactoryServiceImpl()
            val proxy = ProxyImpl(service)
            proxy.sale("张三")
        }

        btnDongtai.setOnClickListener {

            // A商品卖家
            val A = AMerchantServiceImplA()
            // B商品卖家
            val B = BMerchantServiceImpl()
            // 购买者
            val customerName = "张三"

            // 代购公司
            val dCompany = DCompany()
//            dCompany.objFactory = A
//
//            val aProxyInstance = dCompany.proxyInstance as ASellService
//            aProxyInstance.sale(customerName)

            dCompany.objFactory = B

            val bProxyInstance = dCompany.proxyInstance as BSellService
            bProxyInstance.sale(customerName)

        }
    }
}