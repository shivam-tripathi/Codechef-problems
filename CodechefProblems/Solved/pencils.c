# include <stdio.h>
int main(void){
	int t;
	scanf("%d",&t);
	while(t--){
		int s; 
		scanf("%d",&s);
		int day=0, collected = 0;
		int loop1;
		while(collected < s){
			day++;
			int temp = 1;
			for(loop1 = 0; ; loop1 ++){
				if (collected + (temp * 2) <= s){
					temp *= 2;
				}
				else 
					break;
			}
			collected += temp;
		}
		printf("%d \n",day);
	}
}
/*
VDT
t = number of terms
s = number of pencils
*/