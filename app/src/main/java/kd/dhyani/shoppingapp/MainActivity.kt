package kd.dhyani.shoppingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import kd.dhyani.shoppingapp.navigation.AppNavGraph
import kd.dhyani.shoppingapp.ui.feature.home.MainScreen
import kd.dhyani.shoppingapp.viewModel.CarViewModel
import kd.dhyani.shoppingapp.viewModel.CategoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavGraph()
        }
    }
}