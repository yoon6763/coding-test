#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
	char content[30];
	int count;
	
	FILE *file = fopen("test05.txt", "w");

	printf("test05.txt ���� ���� �Ϸ�\n");

	printf("1. ���ڿ� �Է�:");
	gets(content);

	printf("2. ���Ͽ� �Է��� ���ڿ��� %s\n", content);
	fputs(content, file);

	printf("3. ���ڿ� �Է�:");
	gets(content);
	fputs(content, file);
	printf("4. ���Ͽ� �߰��� ���ڿ��� %s\n", content);

	printf("5. test05.txt ������ ��ü ������ Ȯ���ϼ���.");


	fclose(file);

}