package net.jahez.jahezchallenge.ui.restaurants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.base.BaseFragment
import net.jahez.jahezchallenge.databinding.FragmentRestaurantsBinding

@AndroidEntryPoint
class RestaurantsFragment : BaseFragment() {

    companion object {
        fun newInstance() = RestaurantsFragment()
    }

    private val viewModel: RestaurantsViewModel by viewModels()
    private lateinit var mBinding: FragmentRestaurantsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBaseViewModel(viewModel)
        mBinding = FragmentRestaurantsBinding.inflate(layoutInflater, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.viewModel = viewModel


        return mBinding.root
    }

}