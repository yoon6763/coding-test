#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int a, b;
	scanf("%d %d", &a, &b);

	int arr[1001] = { 0 };

	int n = 1;
	int cnt = 0;

	for (int i = 1; i <= b; i++) {
		arr[i] = n;
		cnt++;

		if (n == cnt) {
			n++;
			cnt = 0;
		}
	}

	int result = 0;

	for (int i = a; i <= b; i++) {
		result += arr[i];
	}

	printf("%d", result);

	return 0;
}