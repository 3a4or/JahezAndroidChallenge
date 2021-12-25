package net.jahez.jahezchallenge.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.base.BaseFragment
import net.jahez.jahezchallenge.databinding.FragmentSettingsBinding

@AndroidEntryPoint
class SettingsFragment : BaseFragment() {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    private val viewModel: SettingsViewModel by viewModels()
    private lateinit var mBinding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBaseViewModel(viewModel)
        mBinding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.viewModel = viewModel


        return mBinding.root
    }

}