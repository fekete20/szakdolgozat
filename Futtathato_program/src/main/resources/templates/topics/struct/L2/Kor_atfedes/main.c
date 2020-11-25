#include <stdio.h>
#include <math.h>
typedef struct kor {
 double x, y, r;
} Kor;

void beolvas(Kor * k);
int atfed(Kor k1, Kor k2);

int main(void) {
 Kor a, b;
 beolvas(&a);
 beolvas(&b);
 printf("%s\n", atfed(a, b) ? "Atfedik egymast" : "Nem fedik at egymast.");
 return 0;
}

void beolvas(Kor * k) {
 scanf("%lf %lf %lf", &k->x, &k->y, &k->r);
 return ;
}
int atfed(Kor k1, Kor k2) {
 return sqrt(pow(k1.x-k2.x, 2)+pow(k1.y-k2.y, 2))<k1.r+k2.r;
}
