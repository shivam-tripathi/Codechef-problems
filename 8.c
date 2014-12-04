#include <stdio.h>
void main(){
int a[]={3,6,9,1,2,4};
int *k=((&a[2])-1);
printf("%p  %p",&a[2],k);
}


