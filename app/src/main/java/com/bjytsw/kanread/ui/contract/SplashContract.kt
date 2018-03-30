package com.bjytsw.kanread.ui.contract

import com.bjytsw.kanread.ui.base.mvp.IModel
import com.bjytsw.kanread.ui.base.mvp.IPresenter
import com.bjytsw.kanread.ui.base.mvp.IView



class SplashContract {

    interface View : IView{
        fun startActivity()
    }

    interface Model : IModel{
        fun loadData(): Long
    }

    interface Presenter : IPresenter

}