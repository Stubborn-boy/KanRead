package com.bjytsw.kanread.ui

import android.view.View
import com.bjytsw.kanread.ui.base.MvpFragment
import com.bjytsw.kanread.ui.base.mvp.IPresenter
import com.bjytsw.kanread.ui.base.mvp.IView
import com.bjytsw.kanread.ui.contract.MainContract
import com.bjytsw.kanread.ui.contract.NewsContract
import com.bjytsw.kanread.ui.presenter.MainPresenter
import com.bjytsw.kanread.ui.presenter.NewsPresenter

class NewsFragment : MvpFragment<NewsContract.View, NewsPresenter>(), NewsContract.View{

    override fun onLoadPresenter(): NewsPresenter {
        return NewsPresenter()
    }

    override fun initView(view: View?) {

    }

    override fun initData() {

    }

}
