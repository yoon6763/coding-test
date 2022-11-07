#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>



void main() {

	int* arr = (int*)malloc(sizeof(int) * 3);

	arr[0] = 100;
	arr[1] = 200;
	arr[2] = 300;

	arr = (int*)malloc(sizeof(int) * 5);
	arr[3] = 400;
	arr[4] = 500;

	for (int i = 0; i < 5; i++) {
		printf("%d\n", arr[i]);
	}
}