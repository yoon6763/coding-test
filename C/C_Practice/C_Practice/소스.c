#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct customer {
	char name[30];
	int total;
}CT;

int main()
{
	CT* zone;					  // 동적 메모리 공간을 가리키는 포인터
	int n, i, j;


	printf("n을 입력하세요 : ");
	scanf_s("%d", &n);
	getchar();					// 엔터키 제거

	zone = (struct CT*)malloc(10 * sizeof(struct customer));	// 동적 메모리 할당

	for (i = 0; i < n; i++)
	{
		printf("%d번째 고객의 이름 : ", i + 1);
		gets_s(zone[i].name, sizeof(zone[i].name));

		printf("%d번째 고객의 구매기록 총합 : ", i + 1);
		scanf_s("%d", &(zone[i].total));
		getchar();				// 엔터키 제거
	}
	printf("\n\n모든 고객 정보 출력\n\n");

	for (j = 0; j < n; j++)
	{
		printf("\"%s\"고객의 구매기록 총합은 %d원 입니다.\n", zone[j].name, zone[j].total);
	}

	free(zone);					// 할당된 동적 메모리 공간 반납
	return 0;
}