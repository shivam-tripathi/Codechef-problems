#include<stdio.h>
#include<stdlib.h>
void main()
{
    FILE *fp;
    char ch;
    fp=fopen("c.c","r");
    while(1)
    {   
        ch=fgetc(fp);
        if(ch==EOF)
            break;
        printf("%c",ch);
    }
        printf("\n");
        fclose(fp);
}