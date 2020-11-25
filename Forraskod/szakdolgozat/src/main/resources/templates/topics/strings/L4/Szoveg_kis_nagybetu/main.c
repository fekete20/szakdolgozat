#include <stdio.h>
#include <ctype.h>

#define N 255

char* kisbetusit(char *szoveg);
char* nagybetusit(char *szoveg);

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

    printf("A szoveg kisbetusitve: %s\n", kisbetusit(szoveg));
    printf("A szoveg nagybetusitve: %s\n", nagybetusit(szoveg));

    return 0;
}

char* kisbetusit(char *szoveg) {
    char *seged = szoveg;
    while(*szoveg) {
        *szoveg=tolower(*szoveg);
        szoveg++;
    }
    *szoveg = '\0';
    return seged;
}

char* nagybetusit(char *szoveg) {
    char *seged = szoveg;
    while(*szoveg) {
        *szoveg=toupper(*szoveg);
        szoveg++;
    }
    *szoveg = '\0';
    return seged;
}

