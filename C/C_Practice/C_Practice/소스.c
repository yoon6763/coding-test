#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct country { // country 구조체 선언
    int num;
    int medal;
}country;

int main(void) {
    int N, M, t, cnt = 0;
    int g, s, b; // 메달
    country* ct;

    scanf("%d %d", &N, &M); // 국가의 수, 등수를 알고 싶은 수 입력
    ct = (country*)malloc(sizeof(country) * N); // 동적 할당 사용

    for (int i = 0; i < N; i++) { // 국가의 수, 메달의 수 입력
        scanf("%d %d %d %d", &ct[i].num, &g, &s, &b);
        ct[i].medal = 100 * g + 10 * s + b; // 금메달에 100, 은메달에 10 곱하여 저장
    }

    for (int i = 0; i < N; i++) { // 국가의 수만큼 반복
        if (ct[i].num == M) // 국가의 수가 등수를 알고 싶은 수에 도달했을 때
            t = i; // i의 값을 t에 대입 해준다
    }

    for (int i = 0; i < N; i++) {
        if (ct[i].medal > ct[t].medal) // 메달의 수 비교
            cnt++;
    }
    printf("%d\n", cnt + 1); // 한 국가의 등수: 자신보다 더 잘한 나라 수 + 1
    return 0;
}