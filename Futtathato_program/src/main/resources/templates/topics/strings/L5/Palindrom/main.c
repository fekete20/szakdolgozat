#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define N 100

int palindroma(char szoveg[]);

int main() {
     char szoveg[N];
     int i=0;
     char ch;
     printf("q+Enter lenyomasaig olvassa a karaktereket: ");
     while ((ch=getchar()) != 'q') {
         szoveg[i] = ch;
         i++;
     }
     szoveg[i] = '\0';


        printf("Panindroma: %s", palindroma(szoveg) ? "igen" : "nem");
     return 0;
}
int palindroma(char str[]) {
    char* ptr;
    char* aux;

    int i;
     for(i=0; str[i] != '\0'; i++) {
        str[i] = toupper(str[i]);
     }
    ptr = str;
    while (*ptr != '\0') {
        ++ptr;
    }
    --ptr;

    for (aux = str; ptr >= aux;) {
        if(*ptr == ' ') {
            --ptr;
            continue;
        }
        if(*aux == ' ') {
            aux++;
            continue;
        }

        if (*ptr == *aux) {
            --ptr;
            aux++;
        }
        else{
            break;
        }
    }

    if (aux > ptr){
        return 1;
    }
    else{
        return 0;
    }
}
