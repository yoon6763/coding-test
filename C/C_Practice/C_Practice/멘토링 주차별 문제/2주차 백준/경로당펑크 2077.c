#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main() {
    int n;
    char name[30];
    scanf("%d", &n);
    scanf("%s", name);

    char last[] = "rsefaqtdwczxvg";

    if (strchr(last, name[n - 1]) == NULL) printf("%d", 0);
    else printf("%d", 1);
}