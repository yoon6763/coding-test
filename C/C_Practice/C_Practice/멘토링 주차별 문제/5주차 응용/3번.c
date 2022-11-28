#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>

struct NODE {
    struct NODE* child;
    int value;
};

void push(struct NODE* node, int targetVal) {
    struct NODE* newNode = (struct NODE*)malloc(sizeof(struct NODE));
    newNode->value = targetVal;
    newNode->child = NULL;

    if (node->child == NULL) {
        node->child = newNode;
    }
    else {
        struct NODE* nowNode = node->child;
        while (nowNode->child != NULL) {
            nowNode = nowNode->child;
        }
        nowNode->child = newNode;
    }
}

int removeIdx(struct NODE* node, int idx) {
    struct NODE* nowNode = node;
    struct NODE* prevNode = NULL;

    int i = 0;
    while (i < idx) {
        prevNode = nowNode;
        nowNode = nowNode->child;
        i++;
    }

    int result = nowNode->value;

    prevNode->child = nowNode->child;

    return result;
}

void printList(struct NODE* node) {
    struct NODE* nowNode = node->child;
    while (nowNode != NULL) {
        printf("%d ", nowNode->value);
        nowNode = nowNode->child;
    }
}

int main() {
    struct NODE* linkedList = (struct NODE*)malloc(sizeof(struct NODE));
    linkedList->child = NULL;

    push(linkedList, 1);
    push(linkedList, 2);
    push(linkedList, 3);
    push(linkedList, 4);
    push(linkedList, 5);
    push(linkedList, 6);
    push(linkedList, 7);

    removeIdx(linkedList, 4);
    removeIdx(linkedList, 4);
    removeIdx(linkedList, 4);

    printList(linkedList);

    return 0;
}