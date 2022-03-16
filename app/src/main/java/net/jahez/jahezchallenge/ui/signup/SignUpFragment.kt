package net.jahez.jahezchallenge.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.base.BaseFragment


class SignUpFragment : BaseFragment() , SignUpContract.SignupView{

    lateinit var presenter: SignUpPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        presenter = SignUpPresenter(this)
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun startLoginRequest() {
        TODO("Not yet implemented")
    }

    override fun loginSuccess() {
        TODO("Not yet implemented")
    }


}