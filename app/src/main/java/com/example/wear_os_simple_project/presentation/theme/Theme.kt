package com.example.wear_os_simple_project.presentation.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material3.MaterialTheme

@Composable
fun Wear_os_simple_projectTheme(
    content: @Composable () -> Unit
) {
    // Itt állítjuk be a központi színpalettát (wearColorScheme)
    MaterialTheme(
        colorScheme = wearColorScheme,
        content = content
    )
}
