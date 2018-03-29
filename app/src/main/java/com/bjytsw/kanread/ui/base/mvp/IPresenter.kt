package com.bjytsw.kanread.ui.base.mvp

interface IPresenter<T : IView> {
    fun attachView(view: T)
    fun start()
    fun detachView()
}