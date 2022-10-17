#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

int main() {
	FILE* file;

	errno_t err_code = fopen_s(&file, "input.txt", "w"); // 읽기에 성공하면 0 반환

	if (err_code != 0) {
		file = fopen("input.txt", "w");
		printf("input.txt 파일 생성 완료!");
	}

	printf("1. 문자열 입력 :");
	char buffer[100];
	gets_s(buffer, sizeof(buffer));

	for (int i = 0; i < strlen(buffer); i++) {
		fputc(buffer[i], file);
	}


	printf("2. 파일에 쓴 내용 출력 :");
	
	for (int i = 0; i < strlen(buffer); i++) {
		printf("%c", buffer[i]);
	}

	int result = fclose(file);

	// 파일을 성공적으로 닫으면 0 반환, 오류 발생 시 EOF 반환
	if (result == 0) {
		printf("\ninput.txt 파일 닫기 성공!");
	}
	else {
		printf("\ninput.txt 파일 닫기 에러");
	}

}