#include <stdio.h>
int main(){
    int a;
    scanf("%d",&a);
    int b=1;
    while(a!=0){
        b=(b*10)+(a%2);
        a=a/2;
    }
    while(b>1){
        printf("%d",b%10);
        b/=10;
        }
        printf("\n");

}

    
    