package net.jahez.jahezchallenge.base

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.google.android.material.snackbar.Snackbar
import net.jahez.jahezchallenge.R

abstract class BaseFragment : Fragment() {

    val navController: NavController by lazy {
        return@lazy (requireActivity() as MainActivity).navController
    }
    private lateinit var mBaseViewModel: BaseViewModel

    protected fun setBaseViewModel(baseViewModel: BaseViewModel) {
        mBaseViewModel = baseViewModel
        baseViewModel.dataLoading.observe(this, {
            showLoading(it)
        })
    }

    private fun showLoading(show: Boolean) {
        val base = requireActivity()
        if (base is MainActivity) {
            base.showHideProgress(show)
        }
    }

    protected open fun showSuccess(message: String) {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).apply {
            setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.purple_500))
            view.background =
                ResourcesCompat.getDrawable(resources, R.drawable.round_corner_bg, null)
            setActionTextColor(Color.WHITE)
            setAction(R.string.label_dismiss) { dismiss() }
        }.show()
    }

    protected open fun showError(message: String) {
        Snackbar.make(
            requireActivity().findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).apply {
            setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.color_filter4))
            view.background =
                ResourcesCompat.getDrawable(resources, R.drawable.round_corner_bg, null)
            setActionTextColor(Color.WHITE)
            setAction(R.string.label_dismiss) { dismiss() }
        }.show()
    }
}