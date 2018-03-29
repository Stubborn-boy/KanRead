package com.bjytsw.kanread.ui.base.mvp

import com.bjytsw.kanread.ui.base.MvpActivity

interface IPresenter<T : IView> {
    fun attachView(view: T)
    fun detachView()
}