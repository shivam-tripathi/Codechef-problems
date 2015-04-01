//www.codechef.com/problems/PLZLYKME
#include <stdio.h>
#include <math.h>

float power(float x,float y){
	float i,c=1;
	for(i=1;i<=y;i++){
		c *= x;
	}
}
int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		float l,d,s,c;
		scanf("%f %f %f %f", &l,&d,&s,&c);
		if((s * power((c+1),d)) >= l){
			puts("ALIVE AND KICKING");
		}
	 	else{
			puts("DEAD AND ROTTING");
		}
	}
}

