#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

typedef struct Birth {
	int year;
	int month;
	int day;
};

typedef struct Student {
	int student_number;
	char name[20];
	struct Birth* Birth;
};

int main() {
	struct Birth birth = { 2002,5,5 };
	struct Student st1 = { 20251234, "홍길동", &birth };
	
	printf("학번 : %d\n", st1.student_number);
	printf("성명 : %s\n", st1.name);
	printf("생년월일 : %d. %d. %d\n", st1.Birth->year, st1.Birth->month, st1.Birth->day);

	return 0;
}