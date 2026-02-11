package com.example.p4_ciudades_javiervictorgloria.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PaleSage,
    onPrimary = Color(0xFF0D1A12),
    primaryContainer = ForestGreen,
    onPrimaryContainer = Color.White,
    secondary = SageOlive,
    background = DeepJungle,
    surface = Color(0xFF16251C),
    onSurface = PaleSage,
    surfaceVariant = Color(0xFF2A3B2F)
)

private val LightColorScheme = lightColorScheme(
    primary = ForestGreen,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFDDE5C1),
    onPrimaryContainer = Color(0xFF1B3022),
    secondary = SageOlive,
    tertiary = WarmTerracotta,
    background = SoftCream,
    surface = Color.White,
    onSurface = DarkLeaf,
    surfaceVariant = Color(0xFFE9EDD9) // Color para las tarjetas (Cards)
)

@Composable
fun P4_Ciudades_JavierVictorGloriaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}