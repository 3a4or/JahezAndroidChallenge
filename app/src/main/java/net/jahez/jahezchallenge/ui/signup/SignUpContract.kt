package net.jahez.jahezchallenge.ui.signup

import net.jahez.jahezchallenge.base.mvp.IBasePresenter
import net.jahez.jahezchallenge.base.mvp.IBaseView

interface SignUpContract {

    interface SignupView : IBaseView{
        fun startLoginRequest()
        fun loginSuccess()
    }

    interface SignupPresenter : IBasePresenter<SignupView>{
        fun validation(userName: String, password: String)
        fun signup(userName: String, password: String)
    }
}