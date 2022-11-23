#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <windows.h>
#include <conio.h>

int main() {
	printf("1. 분 단위, 2. 초 단위 : ");
	int select;
	scanf("%d", &select);

	int duration;
	printf("주기 입력 : ");
	scanf("%d", &duration);
	duration *= 1000;

	if (select == 0) duration *= 60;

	while (1) {
		Sleep(duration);
		printf("(alarmSound)\n");
		printf("\a");
	}
}