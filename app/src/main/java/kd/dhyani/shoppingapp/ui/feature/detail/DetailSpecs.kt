package kd.dhyani.shoppingapp.ui.feature.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kd.dhyani.shoppingapp.R
import kd.dhyani.shoppingapp.ui.components.SpecCard


@Composable
fun DetailSpecs(
    totalCapacity : String,
    highestSpeed : String,
    engineOutput : String
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        SpecCard(
            iconRes = R.drawable.sit,
            title = "Total\nCapacity",
            value = totalCapacity,
            modifier = Modifier.weight(1f)
        )
        SpecCard(
            iconRes = R.drawable.speed,
            title = "Highest\nSpeed",
            value = highestSpeed,
            modifier = Modifier.weight(1f)
        )
        SpecCard(
            iconRes = R.drawable.engine,
            title = "Engine\nOutput",
            value = engineOutput,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun DetailSpecPreview() {
    DetailSpecs(totalCapacity = "2 seates", highestSpeed = "250km/h", engineOutput = "300 hp")
}