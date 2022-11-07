#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void main() {
	int n;

	printf("n을 입력하세요 : ");
	scanf("%d", &n);

	// n의 크기만큼 배열 생성
	int* arr = (int*)malloc(sizeof(int) * n);

	for (int i = 0; i < n; i++) {
		arr[i] = rand() % 100 + 1;
	}
	printf("난수 배열\n");
	for (int i = 0; i < n; i++) {
		printf("%d ", arr[i]);
		if (i != 0 && i % 20 == 0) {
			printf("\n");
		}
	}


	for (int i = 0; i < n; i++) {
		for (int j = i+1; j < n; j++) {
			if (arr[i] > arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}

	printf("\n\n정렬 후\n");
	for (int i = 0; i < n; i++) {
		printf("%d ", arr[i]);
		if (i != 0 && i % 20 == 0) {
			printf("\n");
		}
	}


	free(arr);
}