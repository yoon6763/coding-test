#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct customer {
	char name[30];
	int total;
}CT;

int main()
{
	CT* zone;					  // ���� �޸� ������ ����Ű�� ������
	int n, i, j;


	printf("n�� �Է��ϼ��� : ");
	scanf_s("%d", &n);
	getchar();					// ����Ű ����

	zone = (struct CT*)malloc(10 * sizeof(struct customer));	// ���� �޸� �Ҵ�

	for (i = 0; i < n; i++)
	{
		printf("%d��° ���� �̸� : ", i + 1);
		gets_s(zone[i].name, sizeof(zone[i].name));

		printf("%d��° ���� ���ű�� ���� : ", i + 1);
		scanf_s("%d", &(zone[i].total));
		getchar();				// ����Ű ����
	}
	printf("\n\n��� �� ���� ���\n\n");

	for (j = 0; j < n; j++)
	{
		printf("\"%s\"���� ���ű�� ������ %d�� �Դϴ�.\n", zone[j].name, zone[j].total);
	}

	free(zone);					// �Ҵ�� ���� �޸� ���� �ݳ�
	return 0;
}