package net.jahez.jahezchallenge.ui.login

import net.jahez.jahezchallenge.base.mvp.BasePresenter

class LoginPresenter : BasePresenter<LoginContract.LoginView>,LoginContract.LoginPresenter{

    constructor(loginView: LoginContract.LoginView) {
        this.view = loginView
    }


    override fun validation(userName: String, password: String) {
        if (userName.isNotEmpty() && password.isNotEmpty()) {
            view?.showSuccessToast()
            view?.startLoginRequest()
        }
    }

    override fun login(userName: String, password: String) {
        view?.showHideLoading(true)

        // after making request

        view?.showHideLoading(false)

        view?.loginSuccess()
    }

    override fun getTermsAndConditions() {
        TODO("Not yet implemented")
    }

    fun checkPasswordStrenghth() {

    }

}