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

    printf("����ü �迭�� ����Ͽ� ǰ�� 3���� ó���ϴ� ���α׷�\n");

    struct Item items[3];

    for (int i = 0; i < 3; i++) {
        printf("%d��° ǰ���� ǰ��, ����, �ܰ� �Է�\n", i + 1);
        printf("ǰ�� :");
        scanf("%s", items[i].name);
        printf("���� :");
        scanf("%d", &items[i].count);
        printf("�ܰ� :");
        scanf("%d", &items[i].price);
    }

    printf("\n[3�� ǰ���� ����, �ܰ�, �ݾ� ���]\n");
    printf("��ǰ��\t����\t����\t�ݾ�(õ ��)\n");

    for (int i = 0; i < 3; i++) {
        printf("%s\t%d\t%d\t%d\n", items[i].name, items[i].count, items[i].price, items[i].count * items[i].price);
    }

    return 0;
}