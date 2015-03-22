#include <stdio.h>
int main(){
	int t;
	scanf("%d",&t);
	long long a[100000];
	long long k;
	a[0]=0;
	for(k=1;k<100000;k++){
		a[k]=a[k-1]+k;
	}
	while(t--){
		long long n,s;
		scanf("%lld %lld",&n,&s);
		long long diff=a[n]-s;
		if (diff == 0){
			printf("%d",0);
			continue;
		}
		long long i;
		for(i=n;i>=1;i--){
			if ((diff - i +1)<=0){
				break;
			}
			else{
				diff=diff-i+1;
			}
		}
		printf("%lld\n",n-i+1);
	}
}