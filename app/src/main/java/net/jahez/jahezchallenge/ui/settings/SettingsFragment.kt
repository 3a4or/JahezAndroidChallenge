package net.jahez.jahezchallenge.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.base.BaseFragment
import net.jahez.jahezchallenge.data.entities.SpinnerItemModel
import net.jahez.jahezchallenge.databinding.FragmentSettingsBinding
import net.jahez.jahezchallenge.utils.AppUtils
import net.jahez.jahezchallenge.utils.IdManager
import net.jahez.jahezchallenge.utils.NoFilterAdapter
import java.util.*

@AndroidEntryPoint
class SettingsFragment : BaseFragment() {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    private val viewModel: SettingsViewModel by viewModels()
    private lateinit var mBinding: FragmentSettingsBinding
    private lateinit var languagesAdapter: NoFilterAdapter<SpinnerItemModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBaseViewModel(viewModel)
        mBinding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.viewModel = viewModel
        initLang()
        initDropDown()
        initObserving()

        return mBinding.root
    }

    private fun initLang() {
        viewModel.languages.value = mutableListOf(
            SpinnerItemModel(id = 0, key = "ar", valueAr = getString(R.string.lang_arabic), valueEn = getString(R.string.lang_arabic)),
            SpinnerItemModel(id = 1, key = "en", valueAr = getString(R.string.lang_english), valueEn = getString(R.string.lang_english))
        )
    }

    private fun initDropDown() {
        languagesAdapter = NoFilterAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item)

        viewModel.languages.observe(viewLifecycleOwner, {
            languagesAdapter.clear()
            languagesAdapter.addAll(it)
        })
        mBinding.spLang.setAdapter(languagesAdapter)
        mBinding.spLang.keyListener = null
    }

    private fun initObserving() {
        viewModel.selectedLang.observe(viewLifecycleOwner, {
            if(!Locale.getDefault().language.equals(Locale(it.key).language)) {
                AppUtils.saveInSharedPreference(IdManager.APP_LANGUAGE, it.key)
                AppUtils.setLanguage(it.key, requireActivity())
                AppUtils.setLanguageWithoutReload(it.key, requireActivity())
                requireActivity().recreate()
            }
        })
    }
}