package kd.dhyani.shoppingapp.ui.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kd.dhyani.shoppingapp.R
import kd.dhyani.shoppingapp.domain.CarModel

@Composable
fun PopularList(
    cars: List<CarModel>,
    onCarClick:(CarModel)->Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, bottom = 130.dp)
            .fillMaxWidth()
            .height(600.dp)
    ){
        items(cars) {cars->
            Card(modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.grey))
                .clickable { onCarClick(cars) },
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)) {
                Image(painter = rememberAsyncImagePainter(model = cars.picUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .height(130.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop)
                Text(
                    text = cars.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                Text(
                    text = "$${cars.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
            }}
        }
    }
}

@Preview
@Composable
fun PopularListPreview() {
    val cars = listOf(
        CarModel(
            title = "Honda Civic",
            description = "A reliable and comfortable sedan",
            totalCapacity = "5 seats",
            highestSpeed = "180 km/h",
            engineOutput = "203 hp",
            picUrl = "https://example.com.camry.jpg",
            price = 25000.0,
            rating = 4.5
        ),
        CarModel(
            title = "Honda Civic",
            description = "A reliable and comfortable sedan",
            totalCapacity = "5 seats",
            highestSpeed = "180 km/h",
            engineOutput = "203 hp",
            picUrl = "https://example.com.camry.jpg",
            price = 25000.0,
            rating = 4.5
        ),
        CarModel(
            title = "Honda Civic",
            description = "A reliable and comfortable sedan",
            totalCapacity = "5 seats",
            highestSpeed = "180 km/h",
            engineOutput = "203 hp",
            picUrl = "https://example.com.camry.jpg",
            price = 25000.0,
            rating = 4.5
        )
    )
    PopularList(cars = cars, onCarClick = {})
}