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
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material3.AppScaffold
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ButtonDefaults
import androidx.wear.compose.material3.Icon
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.ScreenScaffold
import androidx.wear.compose.material3.Text
import androidx.wear.compose.material3.TimeText
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.wear_os_simple_project.presentation.theme.SzamoloGombSzin1
import com.example.wear_os_simple_project.presentation.theme.SzamoloGombSzin2
import com.example.wear_os_simple_project.presentation.theme.Wear_os_simple_projectTheme

// Naplózáshoz használt név (TAG), így könnyebb keresni a Logcat-ben
private const val TAG = "WearApp"

// A három különböző képernyő belső neve (útvonala) a navigációhoz
private const val SCREEN_FO = "fo_kepernyo"
private const val SCREEN_MASODIK = "masodik_kepernyo"
private const val SCREEN_LISTA = "lista_kepernyo"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A saját témánkat használjuk, amiben a központi színeket tároljuk
            Wear_os_simple_projectTheme {
                // Elindítjuk a fő alkalmazás-komponenst
                CsupaszWearApp()
            }
        }
    }
}

@Composable
fun CsupaszWearApp() {
    // Navigációs vezérlő: ez jegyzi meg, épp melyik oldalon vagyunk
    val navController = rememberSwipeDismissableNavController()
    
    // A számláló állapotát itt tároljuk a legfelső szinten, hogy ne vesszen el váltáskor
    var szamlalo by remember { mutableIntStateOf(0) }

    // AppScaffold: Az alkalmazás legkülső kerete
    AppScaffold {
        // SwipeDismissableNavHost: Ez kezeli az oldalak közötti váltást és az elhúzós visszalépést
        SwipeDismissableNavHost(
            navController = navController,
            startDestination = SCREEN_FO
        ) {
            // 1. Főképernyő beállítása
            composable(SCREEN_FO) {
                FoKepernyo(
                    szamlalo = szamlalo,
                    onKattintas = { szamlalo++ },
                    onNavigalasLista = { navController.navigate(SCREEN_LISTA) },
                    onNavigalasMasodik = { navController.navigate(SCREEN_MASODIK) }
                )
            }
            // 2. Második képernyő (Információ) beállítása
            composable(SCREEN_MASODIK) {
                MasodikKepernyo(onVissza = { navController.popBackStack() })
            }
            // 3. Lista képernyő beállítása
            composable(SCREEN_LISTA) {
                ListaKepernyo(onVissza = { navController.popBackStack() })
            }
        }
    }
}

@Composable
fun FoKepernyo(
    szamlalo: Int, 
    onKattintas: () -> Unit, 
    onNavigalasLista: () -> Unit,
    onNavigalasMasodik: () -> Unit
) {
    // Haptic: Rezgés visszajelzés gombnyomáskor
    val haptic = LocalHapticFeedback.current
    
    // A gomb színe: páros kattintásnál Mentazöld, páratlannál Korall (a Color.kt-ből)
    val gombSzin = if (szamlalo % 2 == 0) SzamoloGombSzin1 else SzamoloGombSzin2

    // ScreenScaffold: Megjeleníti a pontos időt (TimeText) a képernyő tetején
    ScreenScaffold(timeText = { TimeText() }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background), // Központi háttérszín használata
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Kattintásszámláló felirata
            Text(
                text = "Kattintások: $szamlalo", 
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Számláló gomb - Mentazöld és Korall között váltakozik
            Button(
                onClick = {
                    Log.d(TAG, "Számolj gomb megnyomva")
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    onKattintas()
                },
                colors = ButtonDefaults.buttonColors(containerColor = gombSzin),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Icon(Icons.Filled.Favorite, null, tint = if (szamlalo % 2 == 0) Color.White else Color.Red)
                Spacer(Modifier.width(8.dp))
                Text("Számolj!")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Lista gomb - Ez megmarad a téma szerinti Lila színűnek
            Button(
                onClick = onNavigalasLista,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Icon(Icons.AutoMirrored.Filled.List, null)
                Spacer(Modifier.width(8.dp))
                Text("Lista")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Infó gomb
            Button(
                onClick = onNavigalasMasodik,
                modifier = Modifier.fillMaxWidth(0.7f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Black)
            ) {
                Icon(Icons.Filled.PlayArrow, null)
                Spacer(Modifier.width(8.dp))
                Text("Infó")
            }
        }
    }
}

@Composable
fun ListaKepernyo(onVissza: () -> Unit) {
    // ListState: Jegyezi a lista görgetési pozícióját (hol tartunk a listában)
    val listState = rememberScalingLazyListState()
    
    ScreenScaffold(timeText = { TimeText() }) {
        // ScalingLazyColumn: Speciális Wear OS lista, ami a széleken behúzza az elemeket
        ScalingLazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Lista fejléc eleme
            item {
                Text(
                    "Görgethető lista", 
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // 10 darab gomb legenerálása a listába
            items(10) { index ->
                Button(
                    onClick = { Log.d(TAG, "Elem $index kiválasztva") },
                    modifier = Modifier.fillMaxWidth(0.9f).padding(vertical = 2.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer, // Fehér gomb
                        contentColor = MaterialTheme.colorScheme.onSurface // Fekete betű
                    )
                ) {
                    Text("Elem #$index")
                }
            }

            // Vissza gomb a lista legalján
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onVissza,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.White
                    )
                ) {
                    Text("Vissza")
                }
            }
        }
    }
}

@Composable
fun MasodikKepernyo(onVissza: () -> Unit) {
    // Barack szín definiálása (ezt is ki lehetne tenni a Color.kt-be)
    val barackSzin = Color(0xFFFFDAB9)

    ScreenScaffold(timeText = { TimeText() }) {
        // Box: segít a tartalom pontos középre helyezésében
        Box(
            modifier = Modifier.fillMaxSize().background(barackSzin),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Információ", style = MaterialTheme.typography.titleMedium, color = Color.Black)
                Spacer(modifier = Modifier.height(20.dp))
                Text("Ez a második oldal.", color = Color.Black, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(20.dp))
                
                // Vissza gomb a téma szerinti fehér/fekete színekkel
                Button(
                    onClick = onVissza,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer, 
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    Text("Vissza", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                }
            }
        }
    }
}
