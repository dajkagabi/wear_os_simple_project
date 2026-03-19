# Wear OS Simple Project

Ez egy egyszerű, modern Wear OS alkalmazás, amely a legújabb **Jetpack Compose for Wear OS (Material 3)** könyvtárakat használja. Az alkalmazás célja a Wear OS alapvető funkcióinak bemutatása, mint például a képernyők közötti navigáció, az állapotkezelés és a haptikus visszajelzés.

## Funkciók

*   **Kétképernyős elrendezés:** Főképernyő és egy részletek (vissza) képernyő.
*   **Interaktív számláló:** A főképernyőn egy gombbal növelhető a kattintások száma.
*   **Dinamikus UI:** A gomb színe és az ikon színe változik attól függően, hogy a számláló páros vagy páratlan.
*   **Haptikus visszajelzés:** Minden gombnyomásnál rezgő visszajelzést (LongPress) ad az óra.
*   **Logcat naplózás:** Az alkalmazás eseményei (kattintások, navigáció) követhetők a Logcat-ben a `WearApp` címke segítségével.
*   **Modern Material 3 dizájn:** Wear OS-re optimalizált színek, tipográfia és elrendezés.

## Technológiai stack

*   **Kotlin:** A projekt elsődleges programozási nyelve.
*   **Jetpack Compose for Wear OS:** A felhasználói felület deklaratív felépítéséhez.
*   **Material 3 (Wear):** A legújabb dizájn irányelvek követéséhez.
*   **Haptic Feedback API:** A fizikai visszajelzés kezeléséhez.

## Telepítés és futtatás

1.  Klónozd a projektet vagy töltsd le a forráskódot.
    - git clone https://github.com/dajkagabi/wear_os_simple_project.git
3.  Nyisd meg a projektet **Android Studio**-ban (Ladybug vagy újabb verzió ajánlott).
4.  Várd meg, amíg a Gradle szinkronizáció befejeződik.
5.  Indíts el egy **Wear OS emulátort** (API 30+) vagy csatlakoztass egy fizikai Wear OS órát.
6.  Futtasd az `app` modult.

## Használat

1.  **Főképernyő:** Kattints a "Számolj!" gombra a számláló növeléséhez. Figyeld meg a színek változását és a rezgést.
2.  **Navigáció:** Kattints a "Mehet!" gombra a második oldal megnyitásához.
3.  **Visszalépés:** A második oldalon a fehér "Vissza" gombbal térhetsz vissza a kezdőoldalra.
4.  **Hibakeresés:** Nyisd meg a Logcat ablakot az Android Studio-ban, és írd be a `tag:WearApp` szűrőt az üzenetek követéséhez.

## Projekt felépítése

*   `MainActivity.kt`: Tartalmazza a teljes UI logikát, a navigációt és a komponenseket.
*   `AndroidManifest.xml`: Alapvető Wear OS beállítások (standalone mód, óra funkciók).
*   `build.gradle.kts`: A modern Compose Material 3 függőségek kezelése.

---
Készült tanulási célból, a legújabb Android Wear fejlesztési irányelvek alapján.


<img width="1920" height="1020" alt="Img-1" src="https://github.com/user-attachments/assets/9394f7e1-4105-4a24-90d2-327f06776d61" />

<img width="1920" height="1020" alt="Img-2" src="https://github.com/user-attachments/assets/0820ca62-f04a-40a5-b59b-7b3cc7ea8ce0" />

<img width="1920" height="1020" alt="Img-3" src="https://github.com/user-attachments/assets/766aaf85-d946-4f77-a1a3-0ce714c44762" />




