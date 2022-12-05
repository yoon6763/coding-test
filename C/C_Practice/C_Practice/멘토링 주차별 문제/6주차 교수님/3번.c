#include <stdio.h>
#include <Windows.h>
#include <time.h>

int main() {
    srand(time(NULL));

    int cnt[46] = { 0, };

    for (int i = 0; i < 1000; i++) {
        int lotto[6] = { 0, };

        for (int j = 0; j < 6; j++) {
            int num = rand() % 45 + 1;

            for (int k = 0; k < j; k++) {
                if (lotto[k] == num) {
                    j--;
                    break;
                }
            }

            lotto[j] = num;
        }

        for (int j = 0; j < 6; j++) {
            cnt[lotto[j]]++;
        }
    }

    for (int i = 1; i <= 45; i++) {
        printf("%2d : %d\t%f %\n", i, cnt[i], (float)cnt[i] / 6000);
    }
}