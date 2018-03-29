package com.bjytsw.kanread.ui

import android.view.View
import com.bjytsw.kanread.ui.base.MvpFragment
import com.bjytsw.kanread.ui.base.mvp.IPresenter
import com.bjytsw.kanread.ui.base.mvp.IView
import com.bjytsw.kanread.ui.contract.NewsContract
import com.bjytsw.kanread.ui.presenter.NewsPresenter

class NewsFragment : MvpFragment<IPresenter<IView>>(), NewsContract.View{

    override fun onLoadPresenter(): IPresenter<IView> {
        return NewsPresenter() as IPresenter<IView>
    }

    override fun initView(view: View?) {

    }

    override fun initData() {

    }

}
