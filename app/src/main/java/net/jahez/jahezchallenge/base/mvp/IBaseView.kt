package net.jahez.jahezchallenge.base.mvp

interface IBaseView {
    fun showHideLoading(show: Boolean)
    fun showSuccessToast()
    fun showErrorToast()
}