#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

FILE* file;
errno_t err;

void open() {
	printf("[open() �Լ� ȣ��\n");
	int su = 0x0000035;
	
	file = fopen("sample.dat", "wb");
	fwrite(&su, sizeof(int), 1, file);

	printf("���̳ʸ� ���� ���� : sample.dat\n\n");
	fclose(file);

}

void data_p() {
	printf("[data.p() �Լ� ȣ��]\n");
	int data;

	file = fopen("sample.dat", "rb");
	fread(&data, sizeof(int), 1, file);
	printf("sample.dat ���� ���� ����!\n");
	printf("�о�� ������ : %d(0x00%x)", data, data);
	fclose(file);
}

int main() {
	open();
	data_p();
}