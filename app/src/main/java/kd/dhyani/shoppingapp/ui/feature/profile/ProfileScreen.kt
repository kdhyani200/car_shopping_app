package kd.dhyani.shoppingapp.ui.feature.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kd.dhyani.shoppingapp.R

@Composable
fun ProfileScreen(onBack:()->Unit) {
    val scroll = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ){
        ProfileHeader(onBack = onBack)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 320.dp)
                .clip(RoundedCornerShape(R.color.white))
                .background(color = colorResource(id = R.color.white))
                .verticalScroll(scroll)
        ) {
            Text(
                text = "Common Function",
                color = colorResource(id = R.color.black),
                fontSize = 20.sp,
                modifier = Modifier.padding(24.dp),
                fontWeight = FontWeight.Bold
            )
            ProfileQuickActions()
            ProfileSettings()
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.black),
                    containerColor = colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(60.dp)
                    .fillMaxWidth()
                ) {
                Text(text = "Log Out", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}