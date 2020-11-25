#include <stdio.h>

#define N 10

int limitAlatt(double limit, double tomb[]);
int monoton(double tomb[]);
int minimum(double tomb[]);
int maximum(double tomb[]);
double atlag(double tomb[]);

int main()
{
    double tomb[] = {289.5, 292.6, 390.2, 295.5, 100.4, 300.3, 302.5, 303.3, 303.5, 298.9};

    printf("\nAz árfolyam értéke %d-szer volt %.2f alatt.", limitAlatt(300.0, tomb), 300.0);
    printf("\nA sorozat monoton növő: %s", monoton(tomb) ? "igaz" : "hamis");
    printf("\nA sorozat legkisebb eleme %.1f, sorszama %d", tomb[minimum(tomb)], minimum(tomb)+1);
    printf("\nA sorozat legnagyobb eleme %.1f, sorszama %d", tomb[maximum(tomb)], maximum(tomb)+1);
    printf("\nAz atlag: %.1f\n", atlag(tomb));

    return 0;
}

int limitAlatt(double limit, double tomb[]) {
    int db = 0;
    int i;
    for (i=0; i<N; i++) {
             if (tomb[i] < limit) db++;
    }
    return db;
}

int monoton(double tomb[]) {
    int found = 0;
    int i;
    for (i=1; i<N && !found; i+=1) {
    if (tomb[i] < tomb[i-1]) found=1;
     }
    return !found;
}

int minimum(double tomb[]) {
    int i;
    int minindex=0;
    for(i=0; i<N; i++) {
        if(tomb[i]<tomb[minindex])
            minindex=i;
    }
    return minindex;
}

int maximum(double tomb[]) {
    int i;
    int maxindex=0;
    for(i=0; i<N; i++) {
        if(tomb[i]>tomb[maxindex])
            maxindex=i;
    }
    return maxindex;
}

double atlag(double tomb[]) {
    double avg = 0.0;
    int i;
    int meret = N;
    for (i=0; i<meret; i++) {
        avg += tomb[i];
    }
    avg /= meret;
    return avg;
}

