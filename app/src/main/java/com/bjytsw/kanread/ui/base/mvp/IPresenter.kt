package com.bjytsw.kanread.ui.base.mvp


interface IPresenter {
    fun attachView(view: IView)
    fun detachView()
}