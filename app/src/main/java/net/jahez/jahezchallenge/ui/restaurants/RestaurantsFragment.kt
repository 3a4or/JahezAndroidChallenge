package net.jahez.jahezchallenge.ui.restaurants

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.jahezchallenge.MyApp
import net.jahez.jahezchallenge.base.BaseFragment
import net.jahez.jahezchallenge.databinding.FragmentRestaurantsBinding
import android.view.MenuInflater
import net.jahez.jahezchallenge.R

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
        setHasOptionsMenu(true)
        val gridLayoutManager = GridLayoutManager(MyApp.appContext, 2, GridLayoutManager.VERTICAL, false)
        mBinding.rvIngredients.layoutManager = gridLayoutManager
        ingredientsAdapter = RestaurantsAdapter()
        mBinding.rvIngredients.adapter = ingredientsAdapter
    }

    private fun initObserving() {
        viewModel.restaurantsList.observe(viewLifecycleOwner, { ingredientsAdapter.submitList(it) })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_options_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_offers -> {
                ingredientsAdapter.submitList(viewModel.restaurantsList.value!!.filter { it.hasOffer })
                true
            }
            R.id.action_distance -> {
                ingredientsAdapter.submitList(viewModel.restaurantsList.value!!.sortedByDescending { it.distance })
                true
            }
            R.id.action_all -> {
                ingredientsAdapter.submitList(viewModel.restaurantsList.value!!)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRestaurants()
    }
}