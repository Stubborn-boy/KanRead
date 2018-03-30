package com.bjytsw.kanread.ui

import android.view.View
import com.bjytsw.kanread.ui.base.MvpFragment
import com.bjytsw.kanread.ui.contract.NewsContract
import com.bjytsw.kanread.ui.presenter.NewsPresenter

class NewsFragment : MvpFragment<NewsPresenter>(), NewsContract.View{

    override fun onLoadPresenter(): NewsPresenter {
        return NewsPresenter(context)
    }

    override fun initView(view: View?) {

    }

    override fun initData() {

    }

}
