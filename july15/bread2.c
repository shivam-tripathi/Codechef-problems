// http://www.codechef.com/JULY15/problems/EGBOBRD
// author @shivamflash

#include <stdio.h>
void main(void){
    int test;
    scanf("%d", &test);
    while(test --){
        long ndays, maxP;
        scanf("%ld %ld", &ndays, &maxP);
        long a [100000];
        int i = 0;
        for(;i < ndays; i++){
            scanf("%ld", &a[i]);
        }
        long x, inc, left;
        long n = 0, carry = 0;

        for(i = 0; i < ndays; i++){
            x = a[i];
            if (carry > x){
                carry = carry - x;
                if (carry > 0) carry -= 1;
                continue;
            }
            inc = (x - carry)/maxP;
            left = (x - carry) - (maxP * inc);
            //printf("(x %ld - carry %ld)/ maxP %ld = inc %ld\n", x, carry, maxP, inc);
            if (left > 0){
                n += inc + 1;
                if (maxP - left > 1)
                    carry = maxP - left - 1;
                else
                    carry = 0;
            }
            else if (left == 0){
                carry = 0;
                n += inc;
            }
            //printf("x -> carry -> n %ld -> %ld -> %ld \n", x , carry, n);
        }
        printf("%ld\n",n);
    }
}
