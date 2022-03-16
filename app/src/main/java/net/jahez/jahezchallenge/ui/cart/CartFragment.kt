package net.jahez.jahezchallenge.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import net.jahez.jahezchallenge.base.BaseFragment
import net.jahez.jahezchallenge.databinding.FragmentCartBinding
import net.jahez.jahezchallenge.ui.restaurants.RestaurantsViewModel

class CartFragment : BaseFragment() {

    companion object {
        fun newInstance() = CartFragment()
    }

    private val viewModel: CartViewModel by viewModels()
    private val viewModel2: RestaurantsViewModel by viewModels()

    private lateinit var cartBinding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        cartBinding = FragmentCartBinding.inflate(layoutInflater, container, false)
        cartBinding.tvTitle.text = "Test"
        cartBinding.viewModel = viewModel
        cartBinding.viewModel2 = viewModel2

        viewModel.isFav.observe(viewLifecycleOwner, Observer {

        })

        return cartBinding.root

    }

}