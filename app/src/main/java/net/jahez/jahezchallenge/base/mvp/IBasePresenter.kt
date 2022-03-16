package net.jahez.jahezchallenge.base.mvp

interface IBasePresenter<ViewT> {

    fun onViewActive(view: ViewT)

    fun onViewInactive()

}