#include <stdio.h>
int main(void){
	int test;
	scanf("%d",&test);
	while(test -- ){
		int n;
		scanf("%d",&n);
		if(n == 0 || n == 1){
			printf("NO \n");
		}
		else
			printf("YES \n");		
	}
	return 0;
}