package com.aupal.vocabank.ui.tabItem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class ScreenData(
    val title: String,
    val content: @Composable () -> Unit,
)
