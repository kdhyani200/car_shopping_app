package kd.dhyani.shoppingapp.ui.feature.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kd.dhyani.shoppingapp.R
import kd.dhyani.shoppingapp.ui.components.SettingsRow

@Composable
fun ProfileSettings() {
    Column {
        SettingsRow(
            icon = R.drawable.review,
            title = "Rating and Review",
            Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )
        SettingsRow(
            icon = R.drawable.contact,
            title = "Contact Support",
            Modifier.padding(horizontal = 16.dp)
        )
        SettingsRow(
            icon = R.drawable.social,
            title = "Social media Link",
            Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )
    }
}