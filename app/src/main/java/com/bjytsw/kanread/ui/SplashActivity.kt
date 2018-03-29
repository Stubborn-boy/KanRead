package com.bjytsw.kanread.ui

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.bjytsw.kanread.R
import com.bjytsw.kanread.ui.base.MvpActivity
import com.bjytsw.kanread.ui.base.mvp.IPresenter
import com.bjytsw.kanread.ui.base.mvp.IView
import com.bjytsw.kanread.ui.contract.SplashContract
import com.bjytsw.kanread.ui.presenter.SplashPresenter

class SplashActivity : MvpActivity<SplashContract.View, SplashPresenter>(), SplashContract.View{

    override fun onLoadPresenter(): SplashPresenter {
        return SplashPresenter()
    }

    override fun initView(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_splash)
    }

    override fun initData() {
        mPresenter.start()
    }

    override fun startActivity(){
        finish()
        var intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit)
    }
}
