#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

typedef struct Item {
	char name[30];
	int price;
};

int is_equal_item(struct Item* i1, struct Item* i2) {
	if (i1 == i2) return 1;
	else return 0;
}

int main() {
	struct Item i1 = { "��Ʈ��", 20000 };
	struct Item i2 = { "����Ʈ��",10000 };


	// ������ 1 �ٸ��� 0
	if (is_equal_item(&i1, &i2) == 0) {
		printf("\"%s\"�� \"%s\"�� �ٸ� ǰ���Դϴ�", i1.name, i2.name);
	}
	else {
		printf("������ ǰ���Դϴ�.");
	}

}