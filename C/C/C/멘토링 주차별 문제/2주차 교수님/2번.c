#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
	FILE* file;

	errno_t err_code = fopen_s(&file, "input.txt", "r"); // �б⿡ �����ϸ� 0 ��ȯ
	
	if (err_code != 0) {
		file = fopen("input.txt", "w");
	}



}