#include <stdio.h>
#include <stdlib.h>
int main(void){
    FILE *fptr;
    char ch;
    fptr=0;
    fptr=fopen("5.c","r");
    if(fptr==NULL){
        printf("file not found");
        exit(1);
    }
    while((ch=fgetc(fptr))!= EOF){
        printf("%c",ch);
    }
    FILE *ptr2;
    ptr2=fopen("5.c","a");
    while(ch=fgetc(stdin)!=EOF){
        fputc(ch,ptr2);
    }

    fclose(fptr);
}