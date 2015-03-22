#include <stdio.h>
void main(){
	char ch;
	int t;
	scanf("%d",&t); ch = getchar();
	while(t--){
		int size;
		scanf("%d",&size);ch = getchar();
		int a[10001]={0};
		int i;
		int max = 0;
		int elem;
		int temp;
		for (i = 0; i < size; ++i){
			scanf("%d",&temp); ch = getchar();
			a[temp]++;
			if (max < a[temp]){
				max=a[temp];
				elem=temp;
			}
			else if(max == a[temp]){
				if(elem > temp)
					elem=temp;
			}
		}
		printf("%d %d\n",elem,max);

	}
}