package kd.dhyani.shoppingapp.ui.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kd.dhyani.shoppingapp.R
import kd.dhyani.shoppingapp.domain.CarModel

@Composable
fun DetailScreen(
    car: CarModel,
    onBack: ()->Unit,
    onFav: ()->Unit={},
    onBuyNow: ()->Unit={}
) {
    val scroll = rememberScrollState()
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = colorResource(id = R.color.white))){
        DetailHeader(
            picUrl = car.picUrl,
            onBack = onBack,
            onFav = onFav
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 450.dp)
                .verticalScroll(scroll)
        ) {
            DetailInfo(title = car.title, rating = car.rating, description = car.description)
            DetailSpecs(totalCapacity = car.totalCapacity, highestSpeed = car.highestSpeed, engineOutput = car.engineOutput)
            DetailPriceBar(price = car.price, onBuyNow)
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    val car = CarModel(
        title = "Tesla Model 5",
        description = "An electric car produced by Tesla, Inc.",
        totalCapacity = "5 seats",
        highestSpeed = "200 mph",
        engineOutput = "670 hp",
        picUrl ="",
        price = 79990.0,
        rating = 4.8
    )
    DetailScreen(
        car = car,
        onBack = {},
        onBuyNow = {},
        onFav = {}
    )
}