package net.jahez.jahezchallenge.ui.forgetpassword

class ForgetPasswordPresenter {

    private lateinit var view: ForgetPasswordView

    constructor(view: ForgetPasswordView) {
        this.view = view
    }

    fun validation(mobile : String) {
        view.startForgetPasswordRequest()
    }

    fun startRequest(mobile : String) {
        view.showErrorToast()
    }

}