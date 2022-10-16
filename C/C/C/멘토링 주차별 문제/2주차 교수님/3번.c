#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

FILE* file;
errno_t err;

void open() {
	printf("[open() 함수 호출\n");
	int su = 0x0000035;
	
	file = fopen("sample.dat", "wb");
	fwrite(&su, sizeof(int), 1, file);

	printf("바이너리 파일 생성 : sample.dat\n\n");
	fclose(file);

}

void data_p() {
	printf("[data.p() 함수 호출]\n");
	int data;

	file = fopen("sample.dat", "rb");
	fread(&data, sizeof(int), 1, file);
	printf("sample.dat 파일 열기 성공!\n");
	printf("읽어온 데이터 : %d(0x00%x)", data, data);
	fclose(file);
}

int main() {
	open();
	data_p();
}