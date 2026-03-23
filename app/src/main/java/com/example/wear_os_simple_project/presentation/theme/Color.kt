package com.example.wear_os_simple_project.presentation.theme

import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material3.ColorScheme

/**
 * Ebben a fájlban tároljuk az összes egyedi színt, amit az alkalmazásban használunk.
 * Így ha meg akarunk változtatni egy színt, csak itt kell átírni.
 */

val HalvanySzurke = Color(0xFFF5F5F5)
val BarackSzin = Color(0xFFFFDAB9)
val ElectricViolet = Color(0xFFE6A9FF)
val SotetSzurke = Color(0xFF333333)

// KIFEJEZETTEN CSAK A SZÁMOLÓ GOMBHOZ:
val SzamoloGombSzin1 = Color(0xFF98FF98)  // Mentazöld
val SzamoloGombSzin2 = Color(0xFFFF7F50) // Korall

// Material 3 színpaletta összeállítása
val wearColorScheme: ColorScheme = ColorScheme(
    primary = ElectricViolet,
    surfaceContainer = Color.White,
    background = HalvanySzurke,
    onBackground = Color.Black,
    onSurface = Color.Black
)
