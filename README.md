# KanRead

模型：表示数据模型和业务逻辑(business logic)。
model层主要负责：
· 从网络，数据库，文件，传感器，第三方等数据源读写数据。
· 对外部的数据类型进行解析转换为APP内部数据交由上层处理。
· 对数据的临时存储,管理，协调上层数据请求。

视图：将数据呈现给用户。一般的视图都只是包含用户界面(UI)，而不包含界面逻辑。
view 层主要负责：
· 提供UI交互
· 在presenter的控制下修改UI。
· 将业务事件交由presenter处理。
注意: View层不存储数据，不与Model层交互。

层现器：作为View与Model交互的中间纽带，处理与用户交互的负责逻辑。
Presenter包含了根据用户在视图中的行为去更新模型的逻辑。视图仅仅只是将用户的行为告知Presenter，
而Presenter负责从视图中取得数据然后发送给模型。

(1) View : 负责绘制UI元素、与用户进行交互
(3) Model : 负责存储、检索、操纵数据
(4) Presenter : 作为View与Model交互的中间纽带，处理与用户交互的逻辑。

在Activity中实现MVP
##接口定义
```
interface IView {}

interface IModel {}

interface IPresenter {
    //在Activity创建时提供一个view对象（view即是Activity）
    fun attachView(view: IView)
    //在Activity销毁时清除view对象，防止内存泄露
    fun detachView()
}
```

##BasePresenter
BasePresenter是IPresenter的实现
```
abstract class BasePresenter<T : IView> : IPresenter {

    var view: T? = null

    override fun attachView(view: IView) {
        this.view = view as T
    }

     override fun detachView() {
        view = null
    }
}
```

##SplashContract
SplashContract封装了3个与具体的某个Activity相关的接口
```
class SplashContract {

    //Activity会实现这个接口，在这个接口中添加一些界面相关的方法
    interface View : IView{
        fun startActivity()
    }

    //在这个接口中添加一些数据操作相关的方法
    interface Model : IModel{
        fun loadData()
    }

    interface Presenter : IPresenter{
        fun load()
    }

}
```

##SplashModel
SplashContract.Model接口的实现类
```
class SplashModel : SplashContract.Model{

    override fun loadData(){

    }

}
```

##SplashPresenter
SplashContract.Presenter接口的实现类
```
class SplashPresenter : BasePresenter<SplashContract.View>, SplashContract.Presenter {

    var context: Context? = null
    var model: SplashModel? = null

    constructor(context: Context){
        this.context = context
        //初始化一个Model对象
        model = SplashModel()
    }
    //通过model操作数据，通过view操作UI
    override fun load() {
        model?.loadData()
        view?.startActivity()
    }

}
```

##MvpBaseActivity
一个简单的基于MVP的BaseActivity
```
abstract class MvpBaseActivity<P : BasePresenter<*>> : AppCompatActivity(), IView{

    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //获取Presenter对象
        mPresenter = onLoadPresenter()
        mPresenter?.attachView(this)
        initView(savedInstanceState)
        initData()
    }

    override fun onDestroy() {
        mPresenter?.detachView()
        super.onDestroy()
    }

    protected abstract fun onLoadPresenter(): P
    protected abstract fun initView(savedInstanceState: Bundle?)
    protected abstract fun initData()
}
```

##SplashActivity
```
class SplashActivity : MvpActivity<SplashPresenter>(), SplashContract.View{

    //提供一个Presenter对象
    override fun onLoadPresenter(): SplashPresenter {
        return SplashPresenter(this)
    }

    override fun initView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)
    }

    override fun initData() {
        mPresenter.load()
    }

    override fun startActivity(){
        var intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
    }
}
```

1. 降低耦合度，实现了Model和View真正的完全分离，可以修改View而不影响Modle
2. 模块职责划分明显，层次清晰
3. 隐藏数据
4. Presenter可以复用，一个Presenter可以用于多个View，而不需要更改Presenter的逻辑（当然是在View的改动不影响业务逻辑的前提下）
5. 利于测试驱动开发。以前的Android开发是难以进行单元测试的（虽然很多Android开发者都没有写过测试用例，但是随着项目变得越来越复杂，没有测试是很难保证软件质量的；而且近几年来Android上的测试框架已经有了长足的发展——开始写测试用例吧），在使用MVP的项目中Presenter对View是通过接口进行，在对Presenter进行不依赖UI环境的单元测试的时候。可以通过Mock一个View对象，这个对象只需要实现了View的接口即可。然后依赖注入到Presenter中，单元测试的时候就可以完整的测试Presenter应用逻辑的正确性。
6. View可以进行组件化。在MVP当中，View不依赖Model。这样就可以让View从特定的业务场景中脱离出来，可以说View可以做到对业务完全无知。它只需要提供一系列接口提供给上层操作。这样就可以做到高度可复用的View组件。
7. 代码灵活性

缺点：
1. Presenter中除了应用逻辑以外，还有大量的View->Model，Model->View的手动同步逻辑，造成Presenter比较笨重，维护起来会比较困难。
2. 由于对视图的渲染放在了Presenter中，所以视图和Presenter的交互会过于频繁。
3. 如果Presenter过多地渲染了视图，往往会使得它与特定的视图的联系过于紧密。一旦视图需要变更，那么Presenter也需要变更了。
4. 额外的代码复杂度及学习成本。
