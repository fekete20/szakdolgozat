#include <stdio.h>

int keruletSzamol(int a, int b);
int teruletSzamol(int a, int b);

int main()
{
    int a;
    int b;

    printf("Teglalap egyik oldala: \n");
    scanf("%d", &a);

    printf("Teglalap másik oldala: \n");
    scanf("%d", &b);

    printf("Teglalap kerülete: %d\n", keruletSzamol(a, b));

    printf("Teglalap területe: %d\n", teruletSzamol(a, b));

    return 0;
}

int keruletSzamol(int a, int b) {
    return 2*(a+b);
}

int teruletSzamol(int a, int b) {
    return a*b;
}



