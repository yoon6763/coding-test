#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

struct WORD {
	char words[100];
	int length;
};

int main() {
	int T = 2;
	char temp[101];

	while (T--) {
		gets(temp);
		char* ptr = strtok(temp, " ");

		struct WORD* words = (struct WORD*)malloc(sizeof(struct WORD));
		int n = 0;

		while (ptr != NULL) {
			words = (struct WORD*)realloc(words, sizeof(struct WORD) * (n + 1));
			strcpy(words[n].words, ptr);
			words[n].length = strlen(ptr);

			n++;
			ptr = strtok(NULL, " ");
		}

		for (int i = 0; i < n; i++) {
			printf("%s %d\n", words[i].words, words[i].length);
		}

		printf("\n");
	}
}