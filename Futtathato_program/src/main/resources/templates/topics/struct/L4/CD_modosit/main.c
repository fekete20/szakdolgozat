#include <stdio.h>

typedef struct CD {
    char cim[40];
    char eloado[40];
    double ar;
    int ev;
} CD;

void beolvas(CD * lemez);
void kiir(CD lemez);
CD modosit(CD * lemez);

int main() {
     CD lemez;
     beolvas(&lemez);
     kiir(modosit(&lemez));
 return 0;
}

void beolvas(CD * lemez) {
     printf("CD cime: ");
     scanf("%s", lemez->cim);
     printf("CD eloadoja: ");
     scanf("%s", lemez->eloado);
     printf("CD ara: ");
     scanf("%lf", &lemez->ar);
     printf("CD megjelenesi eve: ");
     scanf("%d", &lemez->ev);
 return ;
}

void kiir(CD lemez) {
     printf("\nCD cime: %s", lemez.cim );
     printf("\nCD eloadoja: %s", lemez.eloado );
     printf("\nCD ara: %.2f", lemez.ar );
     printf("\nCD megjelenesi eve: %d\n", lemez.ev );
 return ;
}

CD modosit(CD* lemez) {
 lemez->ar *= 1.1;
return *lemez;
}
