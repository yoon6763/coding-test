#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
	char content[30];
	int count;
	
	FILE *file = fopen("test05.txt", "w");

	printf("test05.txt 파일 생성 완료\n");

	printf("1. 문자열 입력:");
	gets(content);

	printf("2. 파일에 입력한 문자열은 %s\n", content);
	fputs(content, file);

	printf("3. 문자열 입력:");
	gets(content);
	fputs(content, file);
	printf("4. 파일에 추가한 문자열은 %s\n", content);

	printf("5. test05.txt 파일의 전체 내용을 확인하세요.");


	fclose(file);

}