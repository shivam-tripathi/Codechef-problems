#include <stdio.h>
int main(){
	int t;//number of test cases
	scanf("%d",&t);
	while(t--){
		long long n;//number of piles
		long long count=0;//Counting largest number of equal piles
		scanf("%lld",&n);
		long long a[100000]={0};
		long long i;
		for(i=0;i<n;i++){
			long long k;
			scanf("%lld",&k);
			a[k]+=1;
			if (count<a[k]){
				count=a[k];
			}
		}
		printf("%lld\n",n-count);
	}
	return 0;
}
