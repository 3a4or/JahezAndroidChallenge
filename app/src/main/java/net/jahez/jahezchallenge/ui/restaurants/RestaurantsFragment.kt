package net.jahez.jahezchallenge.ui.restaurants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.jahezchallenge.MyApp
import net.jahez.jahezchallenge.base.BaseFragment
import net.jahez.jahezchallenge.databinding.FragmentRestaurantsBinding

@AndroidEntryPoint
class RestaurantsFragment : BaseFragment() {

    companion object {
        fun newInstance() = RestaurantsFragment()
    }

    private val viewModel: RestaurantsViewModel by viewModels()
    private lateinit var mBinding: FragmentRestaurantsBinding
    private lateinit var ingredientsAdapter: RestaurantsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBaseViewModel(viewModel)
        mBinding = FragmentRestaurantsBinding.inflate(layoutInflater, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.viewModel = viewModel
        init()
        initObserving()
        return mBinding.root
    }

    private fun init() {
        val gridLayoutManager = GridLayoutManager(MyApp.appContext, 2, GridLayoutManager.VERTICAL, false)
        mBinding.rvIngredients.layoutManager = gridLayoutManager
        ingredientsAdapter = RestaurantsAdapter()
        mBinding.rvIngredients.adapter = ingredientsAdapter
    }

    private fun initObserving() {
        viewModel.restaurantsList.observe(viewLifecycleOwner, { ingredientsAdapter.submitList(it) })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRestaurants()
    }
}