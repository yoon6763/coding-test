#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int main() {

    int arr[5][5];

    srand(time(NULL));

    char order = '0';
    while (order != 'q') {

        int count[10] = { 0, }; // 각각 몇 번 등장했는지 카운트

        for (int i = 0; i < 5; ++i) {   // 행렬 값 채우기
            for (int j = 0; j < 5; ++j) {
                arr[i][j] = rand() % 10;
                count[arr[i][j]]++;
            }
        }

        int max = -1;
        int min = 26;
        for (int i = 0; i < 10; ++i) {  // 최대값과 최소값 구하기
            if (count[i] > max)
                max = count[i];
            if (count[i] < min)
                min = count[i];
        }

        int max_list[10] = { 0, };
        int min_list[10] = { 0, };

        for (int i = 0; i < 10; ++i) {
            if (count[i] == max) {
                max_list[i] = 1;
            }
            if (count[i] == min) {
                min_list[i] = 1;
            }
        }


        printf("다음 정방행렬에서 가장 많이 나타난 숫자와 가장 적게 나타난 숫자를 맞추세요.\n");

        for (int i = 0; i < 5; ++i) {   // 행렬 출력
            for (int j = 0; j < 5; ++j) {
                printf("%d ", arr[i][j]);
            }
            printf("\n");
        }

        printf("count : ");
        for (int i = 0; i < 10; ++i) {
            printf("%d ", count[i]);
        }

        int check_max = 0;
        int check_min = 0;
        int start = clock();

        while (!check_max || !check_min && (int)((clock() - start) / CLOCKS_PER_SEC) <= 10) {
            int copy[10];
            char m[100];

            for (int i = 0; i < 10; ++i) {
                copy[i] = max_list[i];
            }

            printf("\n가장 많이 나타난 수를 입력해주세요 (복수라면 띄어쓰기 구분)\n");
            gets(m);

            char* tok;
            tok = strtok(m, " ");
            check_max = 1;
            while (tok != NULL) {
                if (count[atoi(tok)] != max) break;
                copy[atoi(tok)] = 0;
                tok = strtok(NULL, " ");
            }

            for (int i = 0; i < 10; ++i) {
                if (copy[i] == 1) {
                    check_max = 0;
                    break;
                }
            }

            if (check_max == 0) {
                printf("틀렸습니다. 다시 입력하세요.");
                continue;
            }

            for (int i = 0; i < 10; ++i) {
                copy[i] = min_list[i];
            }

            printf("\n가장 적게 나타난 수를 입력해주세요 (복수라면 띄어쓰기 구분)\n");
            gets(m);

            tok = strtok(m, " ");
            check_min = 1;
            while (tok != NULL) {
                if (count[atoi(tok)] != min) break;
                copy[atoi(tok)] = 0;
                tok = strtok(NULL, " ");
            }

            for (int i = 0; i < 10; ++i) {
                if (copy[i] == 1) {
                    check_min = 0;
                    break;
                }
            }

            if (check_min == 0) {
                printf("틀렸습니다. 다시 입력하세요.");
                continue;
            }
        }

        if (check_max && check_min) {
            printf("\n모두 맞았습니다!! 프로그램을 종료합니다.\n");
            break;
        }
        else if ((int)((clock() - start) / CLOCKS_PER_SEC) > 10) {
            printf("\n시간 초과입니다.");
            break;
        }
        else {
            printf("틀렸습니다. 다시 시도하려면 아무키나 누르세요.(종료는 q)");
            scanf_s("%c", &order);
        }

    }
}