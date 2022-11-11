#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

float avg(int a, int b);

void main() {
	int a, b;
	printf("중간고사 : ");
	scanf("%d", &a);
	printf("기말고사 : ");
	scanf("%d", &b);
	printf("평균 : %f", avg(a, b));
}