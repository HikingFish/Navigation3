package com.example.navigation3.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.navigation3.R

data class BottomNavItem(
    val icon: Int,
    val title: String
)

val TOP_LEVEL_DESTINATIONS = mapOf(
    Route.TodoList to BottomNavItem(
        icon = R.drawable.outline_checklist_24,
        title = "Todos"
    ),
    Route.TodoFavorite to BottomNavItem(
        icon = R.drawable.baseline_favorite_24,
        title = "Favourites"
    ),
    Route.Settings to BottomNavItem(
        icon = R.drawable.baseline_settings_24,
        title = "Settings"
    )
)