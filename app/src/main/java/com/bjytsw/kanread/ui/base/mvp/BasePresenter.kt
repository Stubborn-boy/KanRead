package com.bjytsw.kanread.ui.base.mvp


abstract class BasePresenter<T : IView> : IPresenter{

    var view: T? = null
        protected set

    val isViewAttached: Boolean
        get() = view != null

    override fun attachView(view: IView) {
        this.view = view as T
    }

     override fun detachView() {
        view = null
    }
}