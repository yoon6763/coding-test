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
            printf("=== ����� �� ===\n");
            printf("���� �Է� :");

            scanf("%d", &myScore[round]);
            if (myScore[round] < 1 || myScore[round] > 10) {
                printf("1 ~ 10 ������ ���ڸ� �Է����ּ���\n");
                continue;
            }
            if (check[myScore[round]]) {
                printf("�ߺ��� �����Դϴ�\n\n");
                continue;
            }

            check[myScore[round]] = true;
            totalScore += myScore[round];

        }
        else {
            printf("=== ��ǻ���� �� ===\n");
            do {
                cpScore[round] = rand() % 10 + 1;
            } while (check[cpScore[round]]);

            check[cpScore[round]] = true;
            totalScore += cpScore[round];
        }

        printf("��ǻ�� ");
        for (int i = 0; i <= round; i++) {
            printf("%2d ", cpScore[i]);
        }

        if (turn) {
            printf("\n����� ");
            for (int i = 0; i <= round; i++) {
                printf("%2d ", myScore[i]);
            }
        }
        else {
            printf("\n����� ");
            for (int i = 0; i <= round - 1; i++) {
                printf("%2d ", myScore[i]);
            }
        }


        printf("\n���� �հ� : %d\n\n", totalScore);

        if (totalScore >= 50) {
            if (turn) printf("����� �̰���ϴ�\n");
            else printf("��ǻ�Ͱ� �̰���ϴ�\n");
            break;
        }

        if (turn) round++;
        turn = !turn;
    }
}