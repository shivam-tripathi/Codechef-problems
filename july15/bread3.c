// http://www.codechef.com/JULY15/problems/EGBOBRD
// author @shivamflash

#include <stdio.h>
void main(void){
    int test;
    scanf("%d", &test);
    while( test --){
        long ndays, maxP;
        scanf("%ld %ld", &ndays, &maxP);
        int a[5003];
        int i = 0;
        long leftover = maxP, n = 1;
        long x, inc;
        while( i<ndays ){
            scanf("%ld", &x); i++;
            if ( x == leftover || (x+1) == leftover){
                n += 1;
                leftover = maxP;
            }
            else if (x < leftover){
                leftover -= x;
                if (leftover != maxP) leftover -= 1;
            }
            else if (x > leftover){
                x -= leftover;
                inc = x/maxP;
                leftover = maxP - (x - (maxP*inc));
                if (leftover == 1 && maxP != 1) {
                    n += inc + 2;
                    leftover = maxP;
                }
                else {
                    n += inc + 1;
                    if (leftover != maxP) leftover -= 1;
                }
                // printf("x, inc, leftover, n = %ld %ld %ld %ld\n", x, inc, leftover, n);
            }
        }
        if (leftover == maxP) printf("%ld\n",n-1);
        else printf("%ld\n",n);
    }
}
