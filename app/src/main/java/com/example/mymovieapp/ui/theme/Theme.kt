package com.example.mymovieapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import com.example.mymovieapp.ui.config.ComponentConfig
import com.example.mymovieapp.ui.config.DefaultComponentConfig
import com.example.mymovieapp.ui.theme.color.ColorSet
import com.example.mymovieapp.ui.theme.color.MyColors

private val LocalMyColors = staticCompositionLocalOf<MyColors> {
    error("No MyColors provided")
}

@Composable
fun MyMovieAppTheme(
    themeState: State<ComponentConfig> = mutableStateOf(DefaultComponentConfig.RED_THEME),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val myTheme by remember { themeState }

    val context = LocalContext.current
    val useDarkTheme = myTheme.isDarkTheme

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (useDarkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        useDarkTheme -> myTheme.colors.DarkColors.material
        else -> myTheme.colors.LightColors.material
    }

    val myColors = when {
        useDarkTheme -> myTheme.colors.DarkColors
        else -> myTheme.colors.LightColors
    }

    CompositionLocalProvider(LocalMyColors provides myColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = myTheme.typography,
            shapes = myTheme.shapes,
            content = content
        )
    }
}