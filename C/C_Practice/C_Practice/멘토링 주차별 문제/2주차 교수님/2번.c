#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main() {
	FILE* file;

	errno_t err_code = fopen_s(&file, "input.txt", "w"); // �б⿡ �����ϸ� 0 ��ȯ

	if (err_code != 0) {
		file = fopen("input.txt", "w");
		printf("input.txt ���� ���� �Ϸ�!");
	}

	printf("1. ���ڿ� �Է� :");
	char buffer[100];
	gets_s(buffer, sizeof(buffer));

	for (int i = 0; i < strlen(buffer); i++) {
		fputc(buffer[i], file);
	}


	printf("2. ���Ͽ� �� ���� ��� :");
	
	for (int i = 0; i < strlen(buffer); i++) {
		printf("%c", buffer[i]);
	}

	int result = fclose(file);

	// ������ ���������� ������ 0 ��ȯ, ���� �߻� �� EOF ��ȯ
	if (result == 0) {
		printf("\ninput.txt ���� �ݱ� ����!");
	}
	else {
		printf("\ninput.txt ���� �ݱ� ����");
	}

}