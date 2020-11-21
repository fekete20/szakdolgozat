#include <stdio.h>
#include <math.h>

int prim(int);
int ikerprim(int, int);

int main()
{
int i, j;
for(i=1; i<=10000; i++) {
if (ikerprim(i, (i+2))) {
printf("(%d, %d), ", i, i+2);
}
}
return 0;
}
int prim(int num) {
int div = 2;
int found = 0;
while (div<=sqrt(num) && !found) {
if (num%div==0)
found = 1;
div++;
}
return !found;
}

int ikerprim(int a, int b) {
if (prim(a) && prim(b)) {
 return 1;
} else return 0;

}
