package com.example.navigation3.navigation

import android.R
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation3.runtime.NavKey

@Composable
fun TodoNavigationBar(
    selectedKey: NavKey,
    onSelectKey: (NavKey) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier
    ) {
        TOP_LEVEL_DESTINATIONS.forEach { (topLevelDestination, data) ->
            NavigationBarItem(
                selected = topLevelDestination == selectedKey,
                onClick = { onSelectKey(topLevelDestination) },
                icon = {
                    Icon(
                        painter = painterResource(id = data.icon),
                        contentDescription = data.title
                    )
                },
                label = {
                    Text(data.title)
                }
            )
        }
    }
}