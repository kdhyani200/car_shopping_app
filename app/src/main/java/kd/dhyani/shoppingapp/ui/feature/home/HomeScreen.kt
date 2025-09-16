package kd.dhyani.shoppingapp.ui.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kd.dhyani.shoppingapp.domain.CarModel
import kd.dhyani.shoppingapp.viewModel.CarViewModel
import kd.dhyani.shoppingapp.viewModel.CategoryViewModel

@Composable
fun MainScreen(
    onProfileClick: () -> Unit,
    onCarClick: (CarModel) -> Unit,
    carViewModel: CarViewModel,
    categoryViewModel: CategoryViewModel
) {
    val categories by categoryViewModel.categories
    val isLoadingCategory by categoryViewModel.isLoading
    val cars by carViewModel.cars
    val isLoadingCars by carViewModel.isLoading

    Scaffold(
        bottomBar = {
            BottomNavBar(
                onProfileClick = onProfileClick,
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffefefef))
                .padding(innerPadding) // 👈 ensures content is not hidden behind BottomNavBar
        ) {
            item {
                HeaderSection(username = "Karan Dhyani", onBellClick = {})
            }
            item {
                SearchSection()
            }
            item {
                if (isLoadingCategory) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    CategoryList(categories = categories)
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier.background(
                        Color.White,
                        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Popular Car", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Text(text = "View All", fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (isLoadingCars) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    } else {
                        PopularList(cars = cars, onCarClick = onCarClick)
                    }
                }
            }
        }
    }
}
