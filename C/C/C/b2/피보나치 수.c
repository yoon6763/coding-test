#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int n, n1 = 0, n2 = 1;
	int cnt = 2;

	scanf("%d", &n);

	if (n <= 2) printf("1");
	else {
		while (cnt++ <= n)
		{
			int sum = n1 + n2;
			n1 = n2;
			n2 = sum;
		}
		printf("%d", n2);
	}

	return 0;
}