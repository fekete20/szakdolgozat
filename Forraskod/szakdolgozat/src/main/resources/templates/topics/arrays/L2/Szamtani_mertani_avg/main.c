#include <stdio.h>
#include <math.h>

#define N 5

double szamtaniAtlag(int tomb[]);
double mertaniAtlag(int tomb[]);

int main() {
     int tomb[N];
     int i;
     printf("Adja meg az 5 elemet");
     for(i = 0; i < N; i++) {
        scanf("%d", &tomb[i]);
     }

     printf("\nA megadott szamok szamtani atlaga: %.2f", szamtaniAtlag(tomb));
     printf("\nA megadott szamok mertani atlaga: %.2f", mertaniAtlag(tomb));

     return 0;
}
double szamtaniAtlag(int tomb[]) {
     int i;
     double osszeg=0;
     for(i=0; i<N; i++)
         osszeg += tomb[i];
     return osszeg/N;
}
double mertaniAtlag(int tomb[]) {
 int i;
 double szorzat=1;
 for(i=0; i<N; i++)
 szorzat *= tomb[i];
 return pow(szorzat,1/(double)N);
}
