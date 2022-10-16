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
	struct Item i1 = { "노트북", 20000 };
	struct Item i2 = { "스마트폰",10000 };


	// 같으면 1 다르면 0
	if (is_equal_item(&i1, &i2) == 0) {
		printf("\"%s\"과 \"%s\"는 다른 품목입니다", i1.name, i2.name);
	}
	else {
		printf("동일한 품목입니다.");
	}

}