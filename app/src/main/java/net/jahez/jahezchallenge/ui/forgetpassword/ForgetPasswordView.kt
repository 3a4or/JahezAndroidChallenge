package net.jahez.jahezchallenge.ui.forgetpassword

interface ForgetPasswordView {
    fun startForgetPasswordRequest()
    fun requestSuccess()
    fun showHideLoading(show: Boolean)
    fun showSuccessToast()
    fun showErrorToast()
}