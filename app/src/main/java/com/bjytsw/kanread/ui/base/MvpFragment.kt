package com.bjytsw.kanread.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bjytsw.kanread.R
import com.bjytsw.kanread.ui.base.mvp.BasePresenter
import com.bjytsw.kanread.ui.base.mvp.IView



abstract class MvpFragment<P : BasePresenter<*>> : Fragment(), IView{

    lateinit var mPresenter: P

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mPresenter = onLoadPresenter()
        mPresenter?.attachView(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.abc_list_menu_item_layout, null, false)
        initView(view)
        initData()
        return view
    }

    fun getPresenter(): P {
        return mPresenter
    }

    override fun onDestroyView() {
        mPresenter?.detachView()
        super.onDestroyView()
    }

    protected abstract fun onLoadPresenter(): P
    protected abstract fun initView(view: View?)
    protected abstract fun initData()
}
