#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct country { // country ����ü ����
    int num;
    int medal;
}country;

int main(void) {
    int N, M, t, cnt = 0;
    int g, s, b; // �޴�
    country* ct;

    scanf("%d %d", &N, &M); // ������ ��, ����� �˰� ���� �� �Է�
    ct = (country*)malloc(sizeof(country) * N); // ���� �Ҵ� ���

    for (int i = 0; i < N; i++) { // ������ ��, �޴��� �� �Է�
        scanf("%d %d %d %d", &ct[i].num, &g, &s, &b);
        ct[i].medal = 100 * g + 10 * s + b; // �ݸ޴޿� 100, ���޴޿� 10 ���Ͽ� ����
    }

    for (int i = 0; i < N; i++) { // ������ ����ŭ �ݺ�
        if (ct[i].num == M) // ������ ���� ����� �˰� ���� ���� �������� ��
            t = i; // i�� ���� t�� ���� ���ش�
    }

    for (int i = 0; i < N; i++) {
        if (ct[i].medal > ct[t].medal) // �޴��� �� ��
            cnt++;
    }
    printf("%d\n", cnt + 1); // �� ������ ���: �ڽź��� �� ���� ���� �� + 1
    return 0;
}