#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <windows.h>
#include <conio.h>

int main() {
	int n = 0;

	while (1) {
		if (_kbhit()) {
			char key = _getch();
			n = 0;
			

			if (key == 'q') {
				break;
			}
		}

		printf("%d\n", n);
		n++;
		Sleep(1000);
	}
}