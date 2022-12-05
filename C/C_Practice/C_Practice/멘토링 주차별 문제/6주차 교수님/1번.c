#include <stdio.h>

#include <Windows.h>

void gotoXY(int x, int y) {
    COORD Pos = { x - 1, y - 1 };
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Pos);
}

void drawSquare(int x, int y) {

    unsigned char a = 0xa6, b[7];

    for (int i = 1; i < 7; i++)
        b[i] = 0xa0 + i;

    gotoXY(x, y);
    printf("%c%c", a, b[3]);
    gotoXY(x + 2, y);
    printf("%c%c", a, b[4]);
    gotoXY(x, y + 1);
    printf("%c%c", a, b[6]);
    gotoXY(x + 2, y + 1);
    printf("%c%c", a, b[5]);
}


int main(void) {
    int x, y;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            x = j * 4 + 1;
            y = i * 2 + 1;
            drawSquare(x, y);
        }
    }
    printf("\n");

    return 0;
}