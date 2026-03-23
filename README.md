# Wear OS Simple Project

Ez egy egyszerű, modern Wear OS alkalmazás, amely a legújabb **Jetpack Compose for Wear OS (Material 3)** könyvtárakat használja. Az alkalmazás célja a Wear OS alapvető funkcióinak bemutatása, mint például a képernyők közötti navigáció, az állapotkezelés és a haptikus visszajelzés.

## Legfrissebb fejlesztések és újdonságok

A projekt folyamatosan bővült a következő modern Wear OS funkciókkal:

*   **Háromképernyős navigáció:** Bevezetésre került egy új "Lista" oldal, így már három különálló képernyő között lehet mozogni (Főoldal, Lista, Infó).
*   **Swipe-to-dismiss navigáció:** Valódi, elhúzós visszalépés funkció a `SwipeDismissableNavHost` használatával, ami a natív óra-élményt biztosítja.
*   **ScalingLazyColumn:** A listaoldalon kerek kijelzőre optimalizált, görgethető listát használunk, amely a széleken behúzza és kicsinyíti az elemeket.
*   **TimeText és Scaffold:** Minden képernyőn látható a pontos idő, amely görgetéskor okosan elhalványul.
*   **Központosított színkezelés:** Bevezettük a `Color.kt` és `Theme.kt` fájlokat. A színeket a `MaterialTheme`-en keresztül kezeljük, így az egész app stílusa egy helyen módosítható.
*   **Egyedi gomb-stílusok:** A számláló gomb egyedi színeket (Mentazöld és Korall) kapott, amelyek függetlenek a téma többi részétől.

## Funkciók

*   **Interaktív számláló:** A főképernyőn egy gombbal növelhető a kattintások száma.
*   **Dinamikus színek:** A számláló gomb színe és az ikon színe váltakozik a kattintások száma (páros/páratlan) alapján.
*   **Haptikus visszajelzés:** Minden gombnyomásnál rezgő visszajelzést (LongPress) ad az óra.
*   **Logcat naplózás:** Az alkalmazás eseményei követhetők a Logcat-ben a `WearApp` címke segítségével.
*   **Magyar nyelvű magyarázatok:** A forráskód minden fontosabb része egyszerű magyar kommentekkel van ellátva a könnyebb tanulás érdekében.

## Technológiai stack

*   **Kotlin:** Elsődleges programozási nyelv.
*   **Jetpack Compose for Wear OS:** Deklaratív UI felépítés.
*   **Wear Navigation:** Elhúzós navigáció kezelése.
*   **Material 3 (Wear):** Modern dizájn irányelvek.

## Telepítés és futtatás

1.  Nyisd meg a projektet **Android Studio**-ban (Ladybug vagy újabb).
    - git clone https://github.com/dajkagabi/wear_os_simple_project.git
2.  Várd meg a Gradle szinkronizációt.
3.  Indíts el egy **Wear OS emulátort** (API 30+) vagy csatlakoztass órát.
4.  Futtasd az `app` modult.

---

<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/7239f115-37ca-4f19-a77f-c68c87ba926a" />

<img width="1920" height="1020" alt="image" src="https://github.com/user-attachments/assets/bae88a32-4b4c-47c9-9bde-76dff11d6fc9" />


Készült tanulási célból, a legújabb Android Wear fejlesztési irányelvek alapján.
