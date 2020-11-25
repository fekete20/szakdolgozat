#include <stdio.h>

int osztoSzamlal(int szam);

int main() {
     int szam;
     printf("\nKérek egy számot: ");
     scanf("%d", &szam);
     printf("\nOsztók száma: %d\n", osztoSzamlal(szam));
     return 0;
 }

 int osztoSzamlal(int szam) {
    int db = 0;
    int oszto = 1;
    while (oszto <= szam) {
        if (szam % oszto == 0) db++;
            oszto++;
     }
 return db;
 }
