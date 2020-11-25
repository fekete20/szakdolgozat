#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#define N 27

int keres(char keresett, char tomb[]);

int main()
{
 char abc[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
'w', 'x', 'y', 'z'};
 char key;
 printf("Adja meg a keresett karaktert: ");
 scanf(" %c", &key);


 if(keres(key, abc)) printf("A keresett karakter a %d. az ABC-ben.\n", keres(key, abc));
 else printf("\nA megadott karakter nincs az ABC-ben.");

 return 0;
}

int keres(char key, char tomb[]) {
    int talalt = 0;
    int i = 0;
    if (isalpha(key)) {
 for(i=0; i<N && !talalt; i++) {
 if (tomb[i] == key || tomb[i] == tolower(key))
    talalt = i+1;
 }
 }
    return talalt;

}
