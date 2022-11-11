#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

int main(void)

{
    unsigned char str[100];
    int i;


    printf("문자열 입력: ");
    scanf("%s", str);

    for (i = 0; str[i] != NULL; i += 2) {
        printf("%c%c = 0x%2x 0x%2x\n", str[i], str[i + 1], str[i], str[i + 1]);
    }

    return 0;

}