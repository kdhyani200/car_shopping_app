package kd.dhyani.shoppingapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kd.dhyani.shoppingapp.R

@Composable
fun TopBar(
    title: String,
    backIconRes: Int,
    onBack:()->Unit,
    modifier: Modifier = Modifier,
    trailingIconRes :Int?=null,
    onTrailingClick :(()->Unit)?=null,
    titleColorRes :Int= R.color.black
) {
    Box(modifier = Modifier.fillMaxWidth()){
        Image(
            painter = painterResource(id = backIconRes),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp)
                .clickable { onBack() }
        )
        Text(
            text = title,
            color = colorResource(id = titleColorRes),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
        trailingIconRes?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 16.dp)
                    .clickable { onTrailingClick?.invoke() }
            )
        }
    }
}