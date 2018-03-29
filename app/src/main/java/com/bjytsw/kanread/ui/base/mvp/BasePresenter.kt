package com.bjytsw.kanread.ui.base.mvp

abstract class BasePresenter<T : IView, M : IModel> : IPresenter<T> {

    var view: T? = null
        protected set

    var model: M? = null
        protected set

    val isViewAttached: Boolean
        get() = view != null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    companion object {

        protected val TAG = "BasePresenter"
    }

}