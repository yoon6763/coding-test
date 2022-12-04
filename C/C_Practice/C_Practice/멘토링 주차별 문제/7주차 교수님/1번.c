#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <Windows.h>
#include <conio.h>


void gotoXY(int x, int y) {
    COORD Pos = { x - 1, y - 1 };
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Pos);
}

int main() {
    const char ball[] = "¡Ü";

    int x = 1, y = 1, key, size = 15, vDir = 1, hDir = 1;

    while (1) {
        key = -1;
        if (_kbhit()) {
            key = _getch();

            switch (key) {
                // Up
            case 72:
                vDir = -1;
                break;

                // Down
            case 80:
                vDir = 1;
                break;

                // Left
            case 75:
                hDir = -1;
                break;

                // Right
            case 77:
                hDir = 1;
                break;

            }
        }

        system("cls");

        if (x + hDir != 0 && y + vDir != 0) {
            gotoXY(x + hDir, y + vDir);
            if (hDir == 1 && vDir == 1) {
                printf("¢Ù");
            }
            else if (hDir == 1 && vDir == -1) {
                printf("¢Ö");
            }
            else if (hDir == -1 && vDir == 1) {
                printf("¢×");
            }
            else if (hDir == -1 && vDir == -1) {
                printf("¢Ø");
            }
        }

        gotoXY(x, y);
        printf("%s", ball);

        if (x + hDir > size || x + hDir < 1) {
            hDir *= -1;
        }
        if (y + vDir > size || y + vDir < 1) {
            vDir *= -1;
        }


        x += hDir;
        y += vDir;

        Sleep(200);
    }
}