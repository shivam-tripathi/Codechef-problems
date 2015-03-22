#include<stdio.h>
#include<stdlib.h>
void main(){
    FILE *fptr,*copy;
    fptr=fopen("e.c","r");
    copy=fopen("copy","w");
    if(fptr==NULL||copy==NULL){
        printf("Error\n");
        exit(1);
    }
    int ch;
    while((ch=fgetc(fptr))!=EOF){
        fprintf(stdout,"%c",ch);
    }
    fclose(fptr);
    fclose(copy);
}

