#include <stdio.h>

int tokeletes(int szam);
int kisebboszto_osszeg(int szam);

int main()
{
    int x;
    printf("Adj meg egy egesz szamot: ");
    scanf("%d", &x);
    printf("%s", tokeletes(x) ? "Tokeletes szam" : "Nem tokeletes szam");
    return 0;
}

int tokeletes(int szam) {
    if (szam == kisebboszto_osszeg(szam))
        return 1;
    return 0;
}

int kisebboszto_osszeg(int szam) {
     int osszeg, oszto;
     osszeg = 0;
     for (oszto=1; oszto<=szam/2; oszto+=1) {
         if (!(szam % oszto))
            osszeg += oszto;
    }
     return osszeg;
}
