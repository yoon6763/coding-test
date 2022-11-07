#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>


int main() {
    char target[5];
    int n;
    int cnt = 0;

    scanf("%s", &target);
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        char mbti[5];
        scanf("%s", &mbti);

        if (strcmp(target, mbti) == 0) cnt++;
    }

    printf("%d", cnt);
}