#include <stdio.h>
#include <string.h>

void printl(long long arr[], int l)
{
    int i = l;
    for(i =0; i<=l; i++){
        if (arr[i] == 0)
            break;
        printf("%d >> %lld|\n", i , arr[i]);
    }
    printf("\n");
}

void printi(int arr[], int l)
{
    int i = l;
    for(i =0; i<=l; i++){
        if (arr[i] == 0)
            break;
        printf("%d >> %d|\n", i , arr[i]);
    }
    printf("\n");
}

long long* nCr(int *arr, int r, long long mod, long long combi[]){
    int l = r+1;
    int c = 0;
    //arr[l-1]+1) ;
    long long row[3999+1] = {0};
    row[0] = 1;

    printf("upper_index\n");
    printi(arr,1212);
    long long i,j;
    for(i = 0; i <= arr[l]; i++)
    {
        for(j = i; j > 0; j--){
            row[j] = (row[j]%mod) + ((row[j - 1])%mod);
        }

        if(i == arr[c]){
            combi[c] = row[r]%mod;
            c += 1;
        }
    }
    printf("%s\n","possible i.e. weak compositions" );
    printl(combi,1000);
    return combi;
}



void main(void){
    int t;
    scanf("%d",&t);
    while(t--){

        int rows, columns, loop;
        scanf("%d %d",&rows,&columns);

        int upper_index[2000+1];
        int lower_index = columns - 1;
        long long mod = 1000000000;

        for(loop = 0; loop <= columns; loop ++){
            upper_index[loop] = loop + lower_index;
            printf(" upper_index :: %d>%d>>%d\n", loop, lower_index, loop+lower_index);
        }


        long long possible[2000+1] = {0};
        nCr(upper_index, lower_index, mod, possible);


        long long copy_possible[2000+1] = {0};
        for(loop = 0; loop <= columns; loop++){
                copy_possible[loop] = possible[loop];
        }

        printf("Copy of compositions\n");
        printl(copy_possible, 100);

        int row;
        for(row = 0; row < rows-1; row++){
            //Add all the possibilities
            long temp = possible[0];
            for(loop = 1; loop <= columns; loop++){
                copy_possible[loop]  = (copy_possible[loop]%mod) + (copy_possible[loop-1]%mod);
                copy_possible[loop-1] = temp;
                printf("elements \n %lld\n",(copy_possible[loop-1]%mod));
                temp = (copy_possible[loop]%mod) * (possible[loop]%mod);
                //copy_possible[loop]  = (copy_possible[loop]%mod) + (copy_possible[loop-1]%mod);
            }
            copy_possible[columns] = temp;

            /*Multiply all the possibilities with the end loop
            for(loop = 1; loop <= columns; loop++)
            {
                copy_possible[loop] = (possible[loop]%mod) * (copy_possible[loop]%mod);
            }*/

            printf("Ans array %d >> ", row);
            printl(copy_possible, 1000);
        }



        long long sum=0;
        for(loop = 0; loop <= columns; loop++){
            if(copy_possible[loop] == 0)
                break;
            sum = (sum%mod)+(copy_possible[loop]%mod);
        }

        printf("%lld\n",(sum%mod));
    }

}
