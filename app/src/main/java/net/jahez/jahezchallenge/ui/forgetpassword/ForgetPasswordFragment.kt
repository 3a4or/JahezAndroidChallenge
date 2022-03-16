package net.jahez.jahezchallenge.ui.forgetpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.jahez.jahezchallenge.R

class ForgetPasswordFragment : Fragment() , ForgetPasswordView{

    private lateinit var presenter: ForgetPasswordPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        presenter = ForgetPasswordPresenter(this)
        return inflater.inflate(R.layout.fragment_forget_password, container, false)
    }

    override fun startForgetPasswordRequest() {
        TODO("Not yet implemented")
    }

    override fun requestSuccess() {
        TODO("Not yet implemented")
    }

    override fun showHideLoading(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun showSuccessToast() {
        TODO("Not yet implemented")
    }

    override fun showErrorToast() {
        TODO("Not yet implemented")
    }

}