package net.jahez.jahezchallenge.base.mvp

open class BasePresenter<ViewT> : IBasePresenter<ViewT> {

    protected var view: ViewT? = null

    override fun onViewActive(view: ViewT) {
        this.view = view
    }

    override fun onViewInactive() {
        view = null
    }
}