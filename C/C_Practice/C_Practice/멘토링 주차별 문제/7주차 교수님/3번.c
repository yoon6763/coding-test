#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

int main() {
    int myScore[11] = { 0 };
    int cpScore[11] = { 0 };
    int totalScore = 0;
    int round = 0;

    bool check[11] = { false };

    bool turn = false;

    srand(time(NULL));

    while (1) {
        if (turn) {
            printf("=== 당신의 턴 ===\n");
            printf("숫자 입력 :");

            scanf("%d", &myScore[round]);
            if (myScore[round] < 1 || myScore[round] > 10) {
                printf("1 ~ 10 사이의 숫자를 입력해주세요\n");
                continue;
            }
            if (check[myScore[round]]) {
                printf("중복된 숫자입니다\n\n");
                continue;
            }

            check[myScore[round]] = true;
            totalScore += myScore[round];

        }
        else {
            printf("=== 컴퓨터의 턴 ===\n");
            do {
                cpScore[round] = rand() % 10 + 1;
            } while (check[cpScore[round]]);

            check[cpScore[round]] = true;
            totalScore += cpScore[round];
        }

        printf("컴퓨터 ");
        for (int i = 0; i <= round; i++) {
            printf("%2d ", cpScore[i]);
        }

        if (turn) {
            printf("\n사용자 ");
            for (int i = 0; i <= round; i++) {
                printf("%2d ", myScore[i]);
            }
        }
        else {
            printf("\n사용자 ");
            for (int i = 0; i <= round - 1; i++) {
                printf("%2d ", myScore[i]);
            }
        }


        printf("\n현재 합계 : %d\n\n", totalScore);

        if (totalScore >= 50) {
            if (turn) printf("당신이 이겼습니다\n");
            else printf("컴퓨터가 이겼습니다\n");
            break;
        }

        if (turn) round++;
        turn = !turn;
    }
}