#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct customer {
	char name[30];
	int sum;
}Customer;

int main() {
	int n, i;

	printf("n�� �Է��ϼ��� : ");
	scanf_s("%d", &n);

	Customer* ct;
	ct = (struct customer*)malloc(n * sizeof(struct customer));

	for (i = 0; i < n; i++) {
		printf("%d��° ���� �̸� : ", i + 1);
		getchar();
		gets_s((ct + i)->name, 30);
		printf("%d��° ���� ���ű�� ���� : ", i + 1);
		scanf_s("%d", &(ct + i)->sum);
	}

	printf("\n\n��� �� ���� ���\n\n");

	for (i = 0; i < n; i++) {
		printf("\"%s\"���� ���ű�� ������ %d�� �Դϴ�.\n", (ct + i)->name, (ct + i)->sum);
	}
}