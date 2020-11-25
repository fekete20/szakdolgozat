#include <stdio.h>
#include <math.h>

typedef struct valosgyok {
 double x1;
 double x2;
} Valosgyok;

typedef struct komplex {
 double valos;
 double kepzetes;
} Komplexgyok;

Valosgyok valosgyokSzamitas(int, int, int, double);
Komplexgyok komplexgyokSzamitas(int, int, int, double);

int main() {
     int a, b, c;
     double d;
     printf("\nKerem a masodfoku egyenlet konstansait: ");
     scanf("%d, %d, %d", &a, &b, &c);
     if (a == 0) {
         if (b == 0) {
         if (c == 0)
            printf("\nBarmely szam megoldas.\n");
         else
            printf("\nNincs megoldas.\n");
         }
         else
            printf("\nAz egyenlet elsofoku, megoldasa: %.2lf\n", -c/(double)b);
     }
     else {
         d = b*b-4*a*c;
         if (d>=0) {
             Valosgyok valosmegoldas = valosgyokSzamitas(a,b,c,d);
             printf("\nAz egyenlet valos gyokei: %.2lf, %.2lf\n",
             valosmegoldas.x1, valosmegoldas.x2);
         }
         else {
             Komplexgyok komplexmegoldas = komplexgyokSzamitas(a,b,c,d);
             printf("\nAz egyenlet komplex gyokei: %.2lf+%.2lfi,%.2lf-%.2lfi\n",
             komplexmegoldas.valos, komplexmegoldas.kepzetes,
             komplexmegoldas.valos, komplexmegoldas.kepzetes);
        }
     }
 return 0;
}

Valosgyok valosgyokSzamitas(int a, int b, int c, double d) {
     Valosgyok eredmeny;
     if (d == 0)
        eredmeny.x1 = eredmeny.x2 = -b/(double)(2*a);
     else if (d > 0) {
         eredmeny.x1 = ((-b)+sqrt(d))/(2*a);
         eredmeny.x2 = ((-b)-sqrt(d))/(2*a);
     }
 return eredmeny;
}

Komplexgyok komplexgyokSzamitas(int a, int b, int c, double d) {
     Komplexgyok eredmeny;
     d = -d;
     eredmeny.valos = (-b)/(double)(2*a);
     eredmeny.kepzetes = sqrt(d)/(2*a);
return eredmeny;
}
