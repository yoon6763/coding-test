#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void) {
    int input;
    unsigned char mark[] = { 0xa1,
                             0xda,
                             0xdf,
                             0xe1,
                             0xe3,
                             0xa2,
                             0xbc,
                             0xbe,
                             0xc0 };


    for (int i = 1; i < 5; i++) {
        printf("%d.%c%c   ", i, mark[0], mark[i]);
    }
    for (int i = 6; i < 9; i++) {
        printf("%d.%c%c  ", i-1, mark[5], mark[i]);
    }

    printf("\n번호를 입력하시오> ");

    scanf("%d", &input);

    if (input <= 4) {
        printf("%c%c", mark[0], mark[input]);
    }
    else {
        printf("%c%c", mark[5], mark[input+1]);
    }
}