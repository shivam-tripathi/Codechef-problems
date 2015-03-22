/* Program to merge lines alternately from two files and writes the results to new file */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main( void ){
    FILE *firstPtr, *secondPtr, *mergedPtr;
    
    /* Open the files */
    firstPtr = fopen("merge.c", "r");
    secondPtr = fopen("lower.c", "r");
    mergedPtr = fopen("merged.txt", "w");
    
    char line1[100], line2[100];
    int i = 1;
    do {
        
    
    fclose(firstPtr);
    fclose(secondPtr);
    fclose(mergedPtr);
    
    return 0;
}
