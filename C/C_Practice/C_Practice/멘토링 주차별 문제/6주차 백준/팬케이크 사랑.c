#include <stdio.h>

int main() {
    int T;
    scanf("%d", &T);

    // 우유 8개, 노른자 8개, 설탕 4스푼, 소금 1스푼, 밀가루 9컵으로 16개의 팬케이크를 만들 수 있음
    // 즉 반죽 1개당 우유 0.5개, 노른자 0.5개, 설탕 0.25스푼, 소금 0.0625스푼, 밀가루 0.5625컵 필요
    double gram1[] = { 0.5, 0.5, 0.25, 0.0625, 0.5625 };

    // 바나나, 딸기, 초콜릿, 호두
    int gram2[] = { 1, 30, 25, 10 };

    while (T--) {
        scanf("\n"); // 공백이 있어 입력을 하나 받음

        int line1[5];
        int line2[4];

        int max = 1000000000;

        for (int i = 0; i < 5; i++) {
            scanf("%d", &line1[i]);
            int nowMax = line1[i] / gram1[i];
            if (max > nowMax) max = nowMax;
        }

        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            scanf("%d", &line2[i]);
            cnt += (line2[i] / gram2[i]);
        }

        if (max < cnt) {
            printf("%d\n", max);
        }
        else {
            printf("%d\n", cnt);
        }
    }
}