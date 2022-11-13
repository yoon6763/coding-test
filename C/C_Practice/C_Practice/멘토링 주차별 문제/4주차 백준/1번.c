#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

void get_bin(int arr[], int n) {
    int i = 0;
    while (n > 0) {
        arr[i] = n % 2;
        n /= 2;
        i++;
    }
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int hour, minute, second;
        scanf("%d:%d:%d", &hour, &minute, &second);

        int bin_hour[6] = { 0 };
        int bin_minute[6] = { 0 };
        int bin_second[6] = { 0 };

        get_bin(bin_hour, hour);
        get_bin(bin_minute, minute);
        get_bin(bin_second, second);

        for (int i = 5; i >= 0; i--) printf("%d%d%d", bin_hour[i], bin_minute[i], bin_second[i]);
        printf(" ");

        for (int i = 5; i >= 0; i--) printf("%d", bin_hour[i]);
        for (int i = 5; i >= 0; i--) printf("%d", bin_minute[i]);
        for (int i = 5; i >= 0; i--) printf("%d", bin_second[i]);

        printf("\n");
    }
}