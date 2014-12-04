#include<stdio.h>
void main(){
	 int i=0,a[4][2]={{12,13},{14,15},{16,17},{18,19}};
	 while(**(a+i)!=18)
	{
		 printf("%d\n",*((*a)+i));
		 i++;
	}
	printf("%p %d",(*a+2),a+1);
	printf("\n%d",**(a+1));

	printf("\n%d",*(*a+2));	
	if(*(a+1)==(*a+2))
	{
		printf("So your life's really a lie!\nFinally something\n");
	}
}