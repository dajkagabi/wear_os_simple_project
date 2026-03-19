package com.example.wear_os_simple_project.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.Icon
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text

// Külön változó deklarálása a könnyebb Logoláshoz.
private const val TAG = "WearApp"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CsupaszWearApp()
        }
    }
}

@Composable
fun CsupaszWearApp() {
    // Állapotkezelés: melyik oldalon vagyunk és hányszor kattintottunk
    var masodikOldalonVagyunk by remember { mutableStateOf(false) }
    var szamlalo by remember { mutableIntStateOf(0) }

    MaterialTheme {
        //Kattintás logika
        if (!masodikOldalonVagyunk) {
            FoKepernyo(
                szamlalo = szamlalo,
                onKattintas = { szamlalo++ },
                onValtas = { masodikOldalonVagyunk = true })
            // Egyszerű navigáció a két képernyő között
        } else {
            MasodikKepernyo(onVissza = { masodikOldalonVagyunk = false })
        }
    }
}

@Composable
fun FoKepernyo(szamlalo: Int, onKattintas: () -> Unit, onValtas: () -> Unit) {
    val haptic = LocalHapticFeedback.current
    // Gomb színe változik a kattintások száma alapján (páros/páratlan)
    val gombSzin = if (szamlalo % 2 == 0) Color(0xFF2196F3) else MaterialTheme.colorScheme.tertiary

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Kattintásszámláló megjelenítése
        Text(text = "Kattintások: $szamlalo", style = MaterialTheme.typography.labelMedium)

        Spacer(modifier = Modifier.height(8.dp))

        // Számláló gomb ikonnal és szöveggel
        Button(
            onClick = {
                Log.d(TAG, "Számolj gomb megnyomva. Jelenlegi állás: $szamlalo")
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                onKattintas()
            },
            colors = ButtonDefaults.buttonColors(containerColor = gombSzin),
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            // Ikon és szöveg elrendezése a gombon belül
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = if (szamlalo % 2 == 0) Color.White else Color.Red
            )
            Spacer(Modifier.width(8.dp))
            Text("Számolj!")
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Navigációs gomb a második oldalra
        Button(
            onClick = {
                Log.d(TAG, "Mehet gomb megnyomva, váltás a második képernyőre")
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                onValtas()
            }, modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text(
                text = "Mehet!", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MasodikKepernyo(onVissza: () -> Unit) {
    val haptic = LocalHapticFeedback.current
    val barackSzin = Color(0xFFFFDAB9)

    // Teljes képernyős doboz háttérszínnel
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(barackSzin),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Részletek",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Vissza gomb: fehér háttér, fekete szöveg, középre igazítva
            Button(
                onClick = {
                    Log.d(TAG, "Vissza gomb megnyomva, visszatérés a főképernyőre")
                    //Rezgés beállítása, most LogCat-által
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    onVissza()
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White, contentColor = Color.Black
                ), modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(
                    text = "Vissza",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
