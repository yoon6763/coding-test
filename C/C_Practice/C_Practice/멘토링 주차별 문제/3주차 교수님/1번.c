#define _CRT_SECURE_NO_WARNINGS
#define MAX_LEN 20
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct NODE {
	char name[MAX_LEN];
	int count;
	struct NODE* next;
};


int main() {
	struct NODE* root;
	struct NODE* now_node;

	root = NULL;
	now_node = NULL;

	while (1) {
		struct NODE* temp_node = (struct NODE*)malloc(sizeof(struct NODE));

		printf("품목 입력(종료는 Q 또는 q) : ");
		scanf("%s", temp_node->name);

		if (strcmp(temp_node->name, "Q") == 0 || strcmp(temp_node->name, "q") == 0) {
			break;
		}
		printf("수량 입력 : ");
		scanf("%d", &temp_node->count);


		temp_node->next = NULL;

		if (root == NULL)
		{
			root = temp_node;
		}
		else
		{
			now_node->next = temp_node;
		}
		now_node = temp_node;
	}

	now_node = root;

	while (now_node != NULL)
	{
		printf("[%s %d] ", now_node->name, now_node->count);
		now_node = now_node->next;
	}
}
