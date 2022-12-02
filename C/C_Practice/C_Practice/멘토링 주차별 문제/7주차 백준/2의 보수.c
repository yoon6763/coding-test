#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
    int bit[32] = { 0 };
    int bitReversed[32] = { 0 };

    int n;
    scanf("%d", &n);

    int idx = 0;

    while (n != 0) {
        if (n % 2 == 1) bit[idx] = 1;
        else bit[idx] = 0;
        n /= 2;
        idx++;
    }

    for (int i = 0; i < 32; i++) {
        if (bit[i] == 1) bitReversed[i] = 0;
        else bitReversed[i] = 1;
    }

    bitReversed[0]++;

    for (int i = 0; i < 32; i++) {
        if (bitReversed[i] == 2) {
            bitReversed[i] = 0;
            bitReversed[i + 1]++;
        }
    }

    int diffCnt = 0;

    for (int i = 0; i < 32; i++) if (bit[i] != bitReversed[i]) diffCnt++;

    printf("%d", diffCnt);
}