package com.bjytsw.kanread.ui.presenter

import android.os.Handler
import com.bjytsw.kanread.ui.base.mvp.BasePresenter
import com.bjytsw.kanread.ui.contract.SplashContract

class SplashPresenter : BasePresenter<SplashContract.View, SplashContract.Model>(), SplashContract.Presenter {

    override fun start() {
        Handler().postDelayed(Runnable {
            view?.startActivity()
        },3000)
    }

}