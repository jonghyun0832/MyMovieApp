package com.example.mymovieapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.mymovieapp.ui.config.ComponentConfig
import com.example.mymovieapp.ui.config.DefaultComponentConfig

@Composable
fun MyMovieAppTheme(
    themeState: State<ComponentConfig> = mutableStateOf(
        DefaultComponentConfig.RED_THEME
    ),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val myTheme by remember { themeState }

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (myTheme.isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        else -> myTheme.colors.LightColors.material
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = myTheme.typography,
        shapes = myTheme.shapes,
        content = content
    )
}