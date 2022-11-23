#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


int getDays(int year, int month, int day)
{
    int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int total = 0;

    total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
    if (!(year % 4) && year % 100 || !(year % 400))months[1]++;

    for (int i = 0; i < month - 1; i++) total += months[i];

    total += day;

    return total;
}


int main(void)
{
    int year, month, day, n;

    printf("기준 날짜 입력 (ex> 2022 11 21) : ");
    scanf("%d %d %d", &year, &month, &day);
    printf("더할 날짜 입력 : ");
    scanf("%d", &n);
    
    int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    int nextYear = getDays(year, 12, 31) - getDays(year, month, day);
    int original = n;
    int i;
    int after;


    if (n > nextYear) //n일이 다음 해를 넘기면
    {
        n -= nextYear;
        year++;
        after = n;

        if (!(year % 4) && year % 100 || !(year % 400)) //윤년 횟수
            after--;

        for (i = 0; i < (n / 365); i++)
        {
            after -= 365; //일년씩 빼끼
            year++;
            if (!(year % 4) && year % 100 || !(year % 400))
                after--;
        }

        if (!(year % 4) && year % 100 || !(year % 400))
            months[1]++;

        for (i = 0; after > months[i]; i++)
            after -= months[i];

        month = i + 1;
        day = after;
    }

    else
    {
        after = n;
        if (!(year % 4) && year % 100 || !(year % 400))
            months[1]++;


        if (day + after < months[month - 1]) //일 수를 더해도 그 달을 못 넘으면
        {
            day = day + after;
        }

        else
        {
            after = after - (months[month - 1] - day);
            month++;

            for (i = month - 1; after > months[i]; i++)
            {
                after = after - months[i];
                month++;
            }

            day = after;
        }
    }

    printf("%d %d %d", original, year, month, day);
}