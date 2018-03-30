package com.bjytsw.kanread.ui.presenter

import android.content.Context
import com.bjytsw.kanread.ui.base.mvp.BasePresenter
import com.bjytsw.kanread.ui.contract.NewsContract

class NewsPresenter : BasePresenter<NewsContract.View>, NewsContract.Presenter {

    var context: Context? = null

    constructor(context: Context?){
        this.context = context
    }

}