#include <stdio.h>
#include <stdlib.h>
#define N 10

int keres(int keresett, int tomb[]);

int main() {
     int tomb[N] = { 6, 12, -3, 7, 4, 9, 56, 34, 0, -21 };
     int keresett, i=0, talalt=0;
     printf("\nA keresett szam: ");
     if (scanf("%d", &keresett)!=1) {
         printf("\nHibas adat!");
         exit(-1);
     }
     if (keres(keresett, tomb)) printf("\nA keresett szam a tomb %d. eleme.\n", keres(keresett, tomb));
     else printf("\nA keresett szam nem eleme a tombnek.\n");
     return 0;
}

int keres(int keresett, int tomb[]) {
    int talalt = 0;
    int i = 0;
    while (i<N && !talalt) {
        if (tomb[i] == keresett) talalt=i+1;
        i++;
    }
    return talalt;

}
