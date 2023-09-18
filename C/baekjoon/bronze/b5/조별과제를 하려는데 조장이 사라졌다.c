#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
	int time;

	scanf("%d", &time);
	int result = time / 5;
	if (time % 5 != 0) {
		result++;
	}

	printf("%d", result);

	return 0;
}