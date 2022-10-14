#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int d1, d2;
	double pi = 3.141592;
	scanf("%d", &d1);
	scanf("%d", &d2);

	printf("%f", d1 * 2 + d2 * 2 * pi);
	
	return 0;
}