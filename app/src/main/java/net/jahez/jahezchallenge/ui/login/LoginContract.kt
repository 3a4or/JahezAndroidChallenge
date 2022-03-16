package net.jahez.jahezchallenge.ui.login

import net.jahez.jahezchallenge.base.mvp.IBasePresenter
import net.jahez.jahezchallenge.base.mvp.IBaseView

interface LoginContract {

    interface LoginView : IBaseView{
        fun startLoginRequest()
        fun loginSuccess()
    }

    interface LoginPresenter : IBasePresenter<LoginView>{
        fun validation(userName: String, password: String)
        fun login(userName: String, password: String)
        fun getTermsAndConditions()
    }
}