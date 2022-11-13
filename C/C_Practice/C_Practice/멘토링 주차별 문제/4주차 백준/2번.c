#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
    int T;

    scanf("%d", &T);

    while (T--) {
        int studentCnt; // �л��� ��
        scanf("%d", &studentCnt);

        int students[101]; // �л����� �� (�ִ� 100��)
        for (int i = 0; i < studentCnt; i++) {
            scanf("%d", &students[i]);
        }

        int participantCnt = 0; // �������� ��
        scanf("%d", &participantCnt);

        int bestScore = 987654321; // �ְ� ����
        int successCnt = 0; // ����� �л� ��
        int bestScoreIdx = 0;

        for (int i = 0; i < participantCnt; i++) {
            int number, hour, min;
            scanf("%d %d %d", &number, &hour, &min);

            for (int j = 0; j < studentCnt; j++) {
                if (students[j] == number) {
                    int score = hour * 60 + min;
                    // ���� �� -1, -1�� �־���, 6�ð� �� ���� �ÿ��� ���ó��
                    if (score >= 0 && score <= 6 * 60) {
                        if (score < bestScore) {
                            bestScore = score;
                            bestScoreIdx = j;
                        }
                        successCnt++;
                    }
                    break;
                }
            }
        }

        printf("%d %d\n", students[bestScoreIdx], successCnt);
    }
}