#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main() {

	int n;
	scanf("%d", &n);

	int line = 0;
	int idx = 0;

	while (idx < n) {
		idx += ++line;
	}

	int gap = idx - n;

	if (line % 2 == 0) {
		printf("%d/%d", line - gap, gap + 1);
	}
	else {
		printf("%d/%d", gap + 1, line - gap);
	}
}