package com.bjytsw.kanread.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bjytsw.kanread.ui.base.mvp.IPresenter
import com.bjytsw.kanread.ui.base.mvp.IView



abstract class MvpActivity<P : IPresenter<IView>> : AppCompatActivity(), IView {

    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = onLoadPresenter()
        mPresenter?.attachView(this)
        initView(savedInstanceState)
        initData()
        mPresenter?.start()

    }

    fun getPresenter(): P {
        return mPresenter
    }

    override fun onDestroy() {
        mPresenter?.detachView()
        super.onDestroy()
    }

    protected abstract fun onLoadPresenter(): P
    protected abstract fun initView(savedInstanceState: Bundle?)
    protected abstract fun initData()
}
