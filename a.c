#include <stdio.h>
void main(int argc,char *argv[]){
	printf("%d",argc);
	int i=0;
	while(i<argc){
		printf("\n here : %s ",argv[i]);
		i++;
	}
}