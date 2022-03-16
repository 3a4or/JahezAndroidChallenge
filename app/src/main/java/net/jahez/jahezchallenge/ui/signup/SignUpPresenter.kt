package net.jahez.jahezchallenge.ui.signup

import net.jahez.jahezchallenge.base.mvp.BasePresenter

class SignUpPresenter : BasePresenter<SignUpContract.SignupView>, SignUpContract.SignupPresenter {

    constructor(loginView: SignUpContract.SignupView) {
        this.view = loginView
    }

    override fun validation(userName: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun signup(userName: String, password: String) {
        TODO("Not yet implemented")
    }
}