package kd.dhyani.shoppingapp.ui.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kd.dhyani.shoppingapp.R
import java.text.NumberFormat
import java.util.Locale

@Composable
fun DetailPriceBar(price : Double, onBuyNow:()->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Price",
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "$" + NumberFormat
                    .getInstance(Locale.US)
                    .format(price),
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
        }
            Button(
                onClick = onBuyNow,
                modifier = Modifier
                    .height(60.dp)
                    .width(180.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.black),
                    contentColor = colorResource(id = R.color.white)
                )
            ) {
                Text(text = "Buy Now", fontSize = 20.sp)
            }
    }
}

@Preview
@Composable
fun DetailPriceBarPreview(){
    DetailPriceBar(price = 20.0, onBuyNow = {})
}