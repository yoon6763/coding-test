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

        int count[10] = { 0, }; // ���� �� �� �����ߴ��� ī��Ʈ

        for (int i = 0; i < 5; ++i) {   // ��� �� ä���
            for (int j = 0; j < 5; ++j) {
                arr[i][j] = rand() % 10;
                count[arr[i][j]]++;
            }
        }

        int max = -1;
        int min = 26;
        for (int i = 0; i < 10; ++i) {  // �ִ밪�� �ּҰ� ���ϱ�
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


        printf("���� ������Ŀ��� ���� ���� ��Ÿ�� ���ڿ� ���� ���� ��Ÿ�� ���ڸ� ���߼���.\n");

        for (int i = 0; i < 5; ++i) {   // ��� ���
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

            printf("\n���� ���� ��Ÿ�� ���� �Է����ּ��� (������� ���� ����)\n");
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
                printf("Ʋ�Ƚ��ϴ�. �ٽ� �Է��ϼ���.");
                continue;
            }

            for (int i = 0; i < 10; ++i) {
                copy[i] = min_list[i];
            }

            printf("\n���� ���� ��Ÿ�� ���� �Է����ּ��� (������� ���� ����)\n");
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
                printf("Ʋ�Ƚ��ϴ�. �ٽ� �Է��ϼ���.");
                continue;
            }
        }

        if (check_max && check_min) {
            printf("\n��� �¾ҽ��ϴ�!! ���α׷��� �����մϴ�.\n");
            break;
        }
        else if ((int)((clock() - start) / CLOCKS_PER_SEC) > 10) {
            printf("\n�ð� �ʰ��Դϴ�.");
            break;
        }
        else {
            printf("Ʋ�Ƚ��ϴ�. �ٽ� �õ��Ϸ��� �ƹ�Ű�� ��������.(����� q)");
            scanf_s("%c", &order);
        }

    }
}