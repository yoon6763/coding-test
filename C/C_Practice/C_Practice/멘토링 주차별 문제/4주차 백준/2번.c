#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
    int T;

    scanf("%d", &T);

    while (T--) {
        int studentCnt; // 학생의 수
        scanf("%d", &studentCnt);

        int students[101]; // 학생들의 수 (최대 100명)
        for (int i = 0; i < studentCnt; i++) {
            scanf("%d", &students[i]);
        }

        int participantCnt = 0; // 참가자의 수
        scanf("%d", &participantCnt);

        int bestScore = 987654321; // 최고 점수
        int successCnt = 0; // 통과한 학생 수
        int bestScoreIdx = 0;

        for (int i = 0; i < participantCnt; i++) {
            int number, hour, min;
            scanf("%d %d %d", &number, &hour, &min);

            for (int j = 0; j < studentCnt; j++) {
                if (students[j] == number) {
                    int score = hour * 60 + min;
                    // 포기 시 -1, -1로 주어짐, 6시간 내 완주 시에만 통과처리
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