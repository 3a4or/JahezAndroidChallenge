package net.jahez.jahezchallenge.base

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityBaseBinding: ActivityMainBinding
    private val viewModel: BaseViewModel by viewModels()
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBaseBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBaseBinding.root)
        setSupportActionBar(activityBaseBinding.toolbar)
        activityBaseBinding.lifecycleOwner = this
        init()
    }

    private fun init() {
        navController = findNavController(R.id.main_nav_fragment)
        setSupportActionBar(activityBaseBinding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        NavigationUI.setupActionBarWithNavController(this, navController)
        activityBaseBinding.viewModel = viewModel

        navController.addOnDestinationChangedListener { _, destination, arguments ->
            var label = destination.label?:""
            if (label.startsWith("{")) {
                label = arguments?.getString(label.removePrefix("{").removeSuffix("}").toString())?:""
            }
            activityBaseBinding.toolbarTitle.text = label
        }
    }

    fun showHideProgress(show: Boolean) {
        viewModel.dataLoading.value = show
    }

    private fun showError(message: String) {
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).apply {
            setBackgroundTint(ContextCompat.getColor(this@MainActivity, R.color.color_filter4))
            view.background =
                ResourcesCompat.getDrawable(resources, R.drawable.round_corner_bg, null)
            setActionTextColor(Color.WHITE)
            setAction(R.string.label_dismiss) { dismiss() }
        }.show()
    }
}