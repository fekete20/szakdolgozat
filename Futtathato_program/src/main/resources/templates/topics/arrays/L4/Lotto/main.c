#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MERET 5

void feltolt(int tomb[]);

int main()
{
     int lotto[MERET];
     int i;
     feltolt(lotto);
     for(i=0; i<MERET; i++) {
        printf("%d. szám: %d\n", i+1, lotto[i]);
     }
     return 0;
}

void feltolt(int tomb[]) {
    int jelolt;
    int i, j;
    srand(time(0));
     for (i=0; i<MERET; ) {
         jelolt = rand()%90+1;
         for(j=0; j<i; j++) {
             if (tomb[j] == jelolt)
                break;
         }
         if (j==i) {
            tomb[i] = jelolt;
            i++;
         }
     }
    return ;
}
