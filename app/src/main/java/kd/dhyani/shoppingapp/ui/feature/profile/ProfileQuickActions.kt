package kd.dhyani.shoppingapp.ui.feature.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kd.dhyani.shoppingapp.R
import kd.dhyani.shoppingapp.ui.components.QuickActionCard

@Composable
fun ProfileQuickActions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        QuickActionCard(
            icon = R.drawable.maintain,
            title ="Maintain",
            Modifier.weight(1f)
        )
        QuickActionCard(
            icon = R.drawable.autopart,
            title ="Auto Parts",
            Modifier.weight(1f)
        )
        QuickActionCard(
            icon = R.drawable.drivingskill,
            title ="Driving Skills",
            Modifier.weight(1f)
        )
    }
}