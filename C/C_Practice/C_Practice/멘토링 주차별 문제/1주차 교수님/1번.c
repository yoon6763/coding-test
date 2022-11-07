#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

typedef struct Item
{
    char name[10];
    int price;
    int count;
};

int main() {

    printf("구조체 배열을 사용하여 품옥 3개를 처리하는 프로그램\n");

    struct Item items[3];

    for (int i = 0; i < 3; i++) {
        printf("%d번째 품목의 품목, 수량, 단가 입력\n", i + 1);
        printf("품목 :");
        scanf("%s", items[i].name);
        printf("수량 :");
        scanf("%d", &items[i].count);
        printf("단가 :");
        scanf("%d", &items[i].price);
    }

    printf("\n[3개 품목의 수량, 단가, 금액 출력]\n");
    printf("상품명\t수량\t가격\t금액(천 원)\n");

    for (int i = 0; i < 3; i++) {
        printf("%s\t%d\t%d\t%d\n", items[i].name, items[i].count, items[i].price, items[i].count * items[i].price);
    }

    return 0;
}