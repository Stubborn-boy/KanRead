package com.bjytsw.kanread.ui.presenter

import android.content.Context
import android.os.Handler
import com.bjytsw.kanread.ui.Model.SplashModel
import com.bjytsw.kanread.ui.base.mvp.BasePresenter
import com.bjytsw.kanread.ui.contract.SplashContract

class SplashPresenter : BasePresenter<SplashContract.View>, SplashContract.Presenter {

    var context: Context? = null
    var model: SplashModel? = null

    constructor(context: Context){
        this.context = context
        model = SplashModel()
    }

    fun start() {
        var delayTime: Long = model!!.loadData()
        Handler().postDelayed(Runnable {
            view?.startActivity()
        }, delayTime)
    }

}