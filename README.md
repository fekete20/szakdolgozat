# szakdolgozat

A webalkalmazás futtatható verziója a Futtathato_program jegyzékben található szakdolgozat-0.0.1-SNAPSHOT.jar fájl, amely Linuxon terminálból a java -jar szakdolgozat-0.0.1-SNAPSHOT.jar parancs kiadásával futtatható.

A .jar fájl mellett található src/main/resources/templates jegyzék alatt vannak az egyes feladatokhoz tartozó tesztesetek, illetve a mintamegoldásokra kiszámított komplexitás értékek. Ezekre az állományokra a szervernek a megfelelő működéshez szüksége van.
Az src/main/resources jegyzékben lévő c_files, c_test_cases, compiled_c_files, compiled_test_cases mappák üresek, ide kerülnek a szerver futása során az ideiglenes fájlok, melyeket a szerver automatikusan eltávolít, amikor már nem szükségesek.

A szerver futtatását Linux (Ubuntu 18.04.5 LTS) operációs rendszeren a JDK 11-es verziója alatt teszteltem.

A megfelelő működéshez a Java-n felül szükséges, hogy telepítve legyenek a számítógépre az alábbi programok:
1. GNU-GCC fordító (telepítése: sudo apt install gcc)
2. CUnit (telepítése: sudo apt-get install libcunit1 libcunit1-doc libcunit1-dev)
3. cppcheck (telepítése: sudo apt install cppcheck)
4. frama-c (telepítése: sudo apt install frama-c)
5. pmccabe (telepítése: sudo apt install pmccabe)

Fejleszőti környezetbe a Forraskod/szakdolgozat jegyzék importálandó.
