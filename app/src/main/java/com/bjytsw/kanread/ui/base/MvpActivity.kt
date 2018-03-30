package com.bjytsw.kanread.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bjytsw.kanread.ui.base.mvp.BasePresenter
import com.bjytsw.kanread.ui.base.mvp.IView



abstract class MvpActivity<P : BasePresenter<*>> : AppCompatActivity(), IView{

    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = onLoadPresenter()
        mPresenter?.attachView(this)
        initView(savedInstanceState)
        initData()
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
