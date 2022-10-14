#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main() {
    char input[16];

    scanf("%s", &input);
    int len = strlen(input);
    int result = 0;

    char* dial[8] = { "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

    for (int i = 0; i < len; i++)
        for (int j = 0; j < 8; j++)
            if (strchr(dial[j], input[i]) != NULL) result += j + 3;

    printf("%d", result);
}