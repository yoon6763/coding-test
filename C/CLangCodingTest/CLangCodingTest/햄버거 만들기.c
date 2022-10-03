#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int a, b;
	scanf("%d %d", &a, &b);
	a /= 2;

	if (a > b) {
		printf("%d", b);
	}
	else {
		printf("%d", a);
	}

	return 0;
}