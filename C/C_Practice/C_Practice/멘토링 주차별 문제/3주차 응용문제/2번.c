#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct Customer {
	char name[30];
	int total;
}CT;

int main() {
	int n;

	scanf("%d", &n);

	CT* cs = (CT*)malloc(sizeof(CT) * n);


	for (int i = 0; i < n; i++) {
		printf("%d번째 고객의 이름 : ", i + 1);
		scanf("%s", &cs[i].name);
		printf("%d번째 고객의 구매기록 종합 : ", i+1);
		scanf("%d", &cs[i].total);
	}

	printf("\n\n모든 고객 정보 출력\n");

	for (int i = 0; i < n; i++) {
		printf("\"%s\"고객의 구매기록 종합은 %d\n", cs[i].name, cs[i].total);
	}

	free(cs);
}