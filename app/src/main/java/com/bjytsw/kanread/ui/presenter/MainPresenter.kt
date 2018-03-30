package com.bjytsw.kanread.ui.presenter

import android.content.Context
import com.bjytsw.kanread.ui.base.mvp.BasePresenter
import com.bjytsw.kanread.ui.contract.MainContract

class MainPresenter : BasePresenter<MainContract.View>, MainContract.Presenter {

    var context: Context? = null

    constructor(context: Context){
        this.context = context
    }

}