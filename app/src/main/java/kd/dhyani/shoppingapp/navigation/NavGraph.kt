package kd.dhyani.shoppingapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kd.dhyani.shoppingapp.domain.CarModel
import kd.dhyani.shoppingapp.ui.feature.detail.DetailScreen
import kd.dhyani.shoppingapp.ui.feature.home.MainScreen
import kd.dhyani.shoppingapp.ui.feature.profile.ProfileScreen
import kd.dhyani.shoppingapp.viewModel.CarViewModel
import kd.dhyani.shoppingapp.viewModel.CategoryViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val categoryViewModel : CategoryViewModel = viewModel()
    val carViewModel : CarViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screens.MAIN){
        composable(Screens.MAIN){
            MainScreen(
                onProfileClick = { navController.navigate(Screens.PROFILE) },
                onCarClick = {car->
                    navController.currentBackStackEntry?.savedStateHandle?.set("car",car)
                    navController.navigate(Screens.DETAIL) },
                carViewModel,
                categoryViewModel
            )
        }
        composable(Screens.PROFILE){
            ProfileScreen(onBack = { navController.popBackStack() })
        }
        composable(Screens.DETAIL){
            val car = navController.previousBackStackEntry?.savedStateHandle?.get<CarModel>("car")
            if(car!=null){
                DetailScreen(car = car, onBack = { navController.popBackStack() })
            }
        }

    }

}
object Screens{
    const val MAIN = "main"
    const val PROFILE = "profile"
    const val DETAIL = "detail"
}