#include <stdio.h>

#include <Windows.h>

void gotoXY(int x, int y) {
    COORD Pos = { x - 1, y - 1 };
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Pos);
}

void drawSquare(int x, int y, int num) {

    unsigned char a = 0xa6, b[7];

    for (int i = 1; i < 7; i++)
        b[i] = 0xa0 + i;

    // »ç°¢Çü
    gotoXY(x, y);
    printf("%c%c", a, b[3]);
    gotoXY(x + 4, y);
    printf("%c%c", a, b[4]);
    gotoXY(x, y + 2);
    printf("%c%c", a, b[6]);
    gotoXY(x + 4, y + 2);
    printf("%c%c", a, b[5]);


    char vertical[] = "¦¢";
    char horizontal[] = "¦¡";

    gotoXY(x + 2, y);
    printf("%s", horizontal);
    gotoXY(x + 2, y + 2);
    printf("%s", horizontal);
    gotoXY(x, y + 1);
    printf("%s", vertical);
    gotoXY(x + 4, y + 1);
    printf("%s", vertical);

    gotoXY(x + 2, y + 1);
    printf("%d", num);
}


int main(void) {
    int x, y;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            x = j * 8 + 1;
            y = i * 4 + 1;
            drawSquare(x, y, j + i * 5 + 1);
        }
    }
    printf("\n");

    return 0;
}