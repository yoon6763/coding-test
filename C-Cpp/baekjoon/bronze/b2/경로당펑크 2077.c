#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main() {
    int n;
    char* name;
    scanf("%d", &n);

    printf("%d", n);

    scanf("%s", &name);

    char last[] = "rsefaqtdwczxvg";

    if (strchr(last, name[n - 1]) != NULL) {
        printf("%d", 1);
    }
    else {
        printf("%d", 0);
    }
}