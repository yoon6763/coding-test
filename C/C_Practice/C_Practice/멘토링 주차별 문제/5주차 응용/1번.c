#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
int main() {
	int w, h;
	scanf("%d %d", &w, &h);

	int** arr = (int**)malloc(sizeof(int) * h);

	for (int i = 0; i < h; i++) {
		arr[i] = (int*)malloc(sizeof(int) * w);
	}

	int n = 1;
	bool flag = true;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			arr[i][j] = n;
			if (flag) n++;
			else n--;

			if (n > 9) flag = false;
			if (n == 0) flag = true;
		}
	}

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
}