package kd.dhyani.shoppingapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kd.dhyani.shoppingapp.R

@Composable
fun SpecCard(iconRes : Int, title : String, value : String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = colorResource(id = R.color.white))
            .padding(top = 16.dp, bottom = 12.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = title,
            color = colorResource(id = R.color.black),
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = value,
            color = colorResource(id = R.color.black),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp)
        )
    }
}

@Preview
@Composable
fun SpecCardPreview() {
    SpecCard(iconRes = 0, title = "Sample Title", value = "Sample Value")
}