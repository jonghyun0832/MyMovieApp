package com.example.mymovieapp.ui.config

import com.example.mymovieapp.ui.theme.Shapes
import com.example.mymovieapp.ui.theme.Typography
import com.example.mymovieapp.ui.theme.color.ColorSet

object DefaultComponentConfig {
    val RED_THEME = ComponentConfig(
        colors = ColorSet.Red,
        shapes = Shapes,
        typography = Typography,
        isDarkTheme = false
    )

    val BLUE_THEME = ComponentConfig(
        colors = ColorSet.Blue,
        shapes = Shapes,
        typography = Typography,
        isDarkTheme = false
    )
}