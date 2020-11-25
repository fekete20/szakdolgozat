#include <stdio.h>
#include <string.h>

#define N 255

char* megfordit(char szoveg[]);

int main()
{
    int i = 0;
    char c;
    char szoveg[N];
    printf("Adja meg a szoveget!\n");
    while((c = getchar()) != 'Q') {
        szoveg[i] = c;
        i++;
    }
    szoveg[i] = '\0';

    printf("%s", megfordit(szoveg));


    return 0;
}

char* megfordit(char szoveg[]) {
    char *p = szoveg;
    char seged;
    int i, j;
    for(i = 0, j = strlen(szoveg)-1; i < strlen(szoveg)/2; i++, j--) {
        seged = szoveg[i];
        szoveg[i] = szoveg[j];
        szoveg[j] = seged;
    }
    return p;
}
