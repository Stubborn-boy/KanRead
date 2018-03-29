package com.bjytsw.kanread.ui.contract

import com.bjytsw.kanread.ui.base.mvp.IModel
import com.bjytsw.kanread.ui.base.mvp.IPresenter
import com.bjytsw.kanread.ui.base.mvp.IView



class NewsContract {

    interface View : IView

    interface Model : IModel

    interface Presenter : IPresenter<View>

}