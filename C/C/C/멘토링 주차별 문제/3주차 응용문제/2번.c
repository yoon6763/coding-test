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
		printf("%d��° ���� �̸� : ", i + 1);
		scanf("%s", &cs[i].name);
		printf("%d��° ���� ���ű�� ���� : ", i+1);
		scanf("%d", &cs[i].total);
	}

	printf("\n\n��� �� ���� ���\n");

	for (int i = 0; i < n; i++) {
		printf("\"%s\"���� ���ű�� ������ %d\n", cs[i].name, cs[i].total);
	}

	free(cs);
}