package kd.dhyani.shoppingapp.ui.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import kd.dhyani.shoppingapp.R


@Composable
@Preview
fun HeaderSection(username: String = "test", onBellClick:()-> Unit={}) {
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .statusBarsPadding()
        .padding(all = 16.dp)) {
        val (profilePic, nameColumn, bellIcon)=createRefs()
        
        Image(painter = painterResource(id = R.drawable.profile),
            contentDescription = null
        , modifier = Modifier
                .size(55.dp)
                .constrainAs(ref = profilePic) {
                    start.linkTo(anchor = parent.start)
                    top.linkTo(anchor = parent.top)
                    bottom.linkTo(anchor = parent.bottom)
                }
        )
        Column(modifier = Modifier.constrainAs(ref = nameColumn) {
            start.linkTo(anchor = profilePic.end, margin = 8.dp)
            top.linkTo(anchor = parent.top)
            bottom.linkTo(anchor = parent.bottom)
        }){
            Text(text = "text", fontSize = 14.sp)
            Text(text = username, fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Image(painter = painterResource(id = R.drawable.bell),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(bellIcon){
                    end.linkTo(anchor = parent.end)
                    top.linkTo(anchor = parent.top)
                    bottom.linkTo(anchor = parent.bottom)
                })
    }
}