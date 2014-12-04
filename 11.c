/* Program to copy the contents of one file to another after converting all the uppercase
   characters to lowercase */
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
int main( void ) {
    FILE *fromPtr, *toPtr;
    fromPtr = fopen("lower.c", "r");
    toPtr = fopen("copy", "w");
    
    if( fromPtr == NULL || toPtr == NULL ){
        printf("Error in opening file.\n");
        exit(1);
    }
    
    int c;
    do {
        c = getc(fromPtr);
        if( isupper(c) )
            putc( tolower(c), toPtr );
        else
            putc(c, toPtr);
    } while( c != EOF );
    
    fclose(fromPtr);
    fclose(toPtr);
    return 0;
}
