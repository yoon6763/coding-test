#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

float avg(int a, int b);

void main() {
	int a, b;
	printf("�߰���� : ");
	scanf("%d", &a);
	printf("�⸻��� : ");
	scanf("%d", &b);
	printf("��� : %f", avg(a, b));
}