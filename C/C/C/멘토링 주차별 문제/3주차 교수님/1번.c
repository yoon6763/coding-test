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
	int flag = 1;
	int input;
	struct NODE* head;
	struct NODE* last;
	struct NODE* node;

	head = NULL;
	last = NULL;

	while (1) {
		char temp_name[MAX_LEN];
		int temp_cnt;

		node = (struct NODE*)malloc(sizeof(struct NODE));

		printf("품목 입력(종료는 Q 또는 q) : ");
		scanf("%s", node->name);

		if (strcmp(node->name, "Q") == 0 || strcmp(node->name, "q") == 0) {
			break;
		}
		scanf("%d", &node->count);


		node->next = NULL;

		if (head == NULL)
		{
			head = node;
		}
		else
		{
			last->next = node;
		}
		last = node;
	}

	struct NODE* temp = head;

	while (temp != NULL)
	{
		printf("[%s %d] ", temp->name, temp->count);
		temp = temp->next;
	}
}
