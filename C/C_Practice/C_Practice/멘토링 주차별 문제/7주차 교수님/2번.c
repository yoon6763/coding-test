#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int arr[5][5];
    int cnt[10] = { 0 };

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            arr[i][j] = rand() % 10;
            cnt[arr[i][j]]++;
        }
    }

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }

    int min = 0, max = 0;

    for (int i = 1; i < 10; i++) {
        if (cnt[i] > cnt[max]) max = i;
        if (cnt[i] < cnt[min]) min = i;
    }

    printf("가장 많은 숫자 : %d, 개수 : %d\n", max, cnt[max]);
    printf("가장 적은 숫자 : %d, 개수 : %d", min, cnt[min]);
}