#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct customer {
	char name[30];
	int sum;
}Customer;

int main() {
	int n, i;

	printf("n을 입력하세요 : ");
	scanf_s("%d", &n);

	Customer* ct;
	ct = (struct customer*)malloc(n * sizeof(struct customer));

	for (i = 0; i < n; i++) {
		printf("%d번째 고객의 이름 : ", i + 1);
		getchar();
		gets_s((ct + i)->name, 30);
		printf("%d번째 고객의 구매기록 총합 : ", i + 1);
		scanf_s("%d", &(ct + i)->sum);
	}

	printf("\n\n모든 고객 정보 출력\n\n");

	for (i = 0; i < n; i++) {
		printf("\"%s\"고객의 구매기록 총합은 %d원 입니다.\n", (ct + i)->name, (ct + i)->sum);
	}
}