#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

int main() {
	int a, b, n;
	int result = 0;

	scanf("%d %d %d", &a, &b, &n);

	for (int i = 0; i < n; i++) {
		a = a % b * 10;
		result = a / b;
	}
	printf("%d", result);

	return 0;
}