void headerfile()
{
	#include <stdio.h>
int main(int argc,char *argv[]){
    if (argc!=2){
        printf("%sfilename\n",argv[0]);
        exit(1);
    }
    else{
        FILE *file=fopen(argv[1],"r");
        if (file==0){
            print("Could not open file\n");
        }
        else{
            int x;
            while((x=fgetc(file))!=EOF){
                printf("%c",c);

            }
            fclose(file);
        }

    }

}
    
}