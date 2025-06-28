package com.example.mymovieapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.mymovieapp.R

private val spoqaBold = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold)
)
private val spoqaRegular = FontFamily(
    Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal)
)
private val spoqaThin = FontFamily(
    Font(R.font.spoqa_han_sans_neo_thin, FontWeight.Thin)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 60.sp,
    ).copy(fontFamily = spoqaRegular),
    displayMedium = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 32.sp,
    ).copy(fontFamily = spoqaRegular),
    displaySmall = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 24.sp
    ).copy(fontFamily = spoqaRegular),
    headlineLarge = TextStyle(
        fontFamily = spoqaThin,
        fontSize = 32.sp
    ).copy(fontFamily = spoqaRegular),
    headlineMedium = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 18.sp
    ).copy(fontFamily = spoqaRegular),
    headlineSmall = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 15.sp
    ).copy(fontFamily = spoqaRegular),
    titleLarge = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 18.sp,
    ).copy(fontFamily = spoqaRegular),
    titleMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp
    ).copy(fontFamily = spoqaRegular),
    bodyLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 15.sp
    ).copy(fontFamily = spoqaRegular),
    bodyMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 15.sp,
    ).copy(fontFamily = spoqaRegular),
    labelLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 18.sp,
    ).copy(fontFamily = spoqaRegular),
    labelMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp
    ).copy(fontFamily = spoqaRegular)
)

val Typography.headlineMediumTitle: TextStyle
    @Composable get() = headlineMedium.copy(
        fontSize = 24.sp
    )

val Typography.dialogButton: TextStyle
    @Composable get() = labelLarge.copy(
        fontSize = 18.sp
    )

val Typography.underlinedDialogButton: TextStyle
    @Composable get() = labelLarge.copy(
        textDecoration = TextDecoration.Underline
    )

val Typography.underlinedButton: TextStyle
    @Composable get() = labelLarge.copy(
        textDecoration = TextDecoration.Underline
    )