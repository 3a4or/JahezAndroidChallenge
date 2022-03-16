package net.jahez.jahezchallenge.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.base.BaseFragment


class LoginFragment : BaseFragment(), LoginContract.LoginView{

    lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        presenter = LoginPresenter(this)
        presenter.checkPasswordStrenghth()
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun startLoginRequest() {
        TODO("Not yet implemented")
    }

    override fun loginSuccess() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewInactive()
    }
    override fun showHideLoading(show: Boolean) {
        TODO("Not yet implemented")
    }
}