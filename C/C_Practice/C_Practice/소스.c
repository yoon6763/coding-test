#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

struct Medal {
    int country;
    int gold;
    int silver;
    int bronze;
}; // 메달 수 구조체 선언

int main() {
    int n, k;
    scanf_s("%d %d", &n, &k);

    struct Medal* medals = malloc(n * sizeof(struct Medal));
    int targetCountry = 0;

    for (int i = 0; i < n; i++) {
        scanf_s("%d %d %d %d", &medals[i].country, &medals[i].gold, &medals[i].silver, &medals[i].bronze);
        if (medals[i].country == k) {
            targetCountry = i;
        }
    }

    int rank = 0;

    for (int i = 0; i < n; i++) {
        if (i != targetCountry) {
            if (medals[i].gold > medals[targetCountry].gold) {
                rank++;
            }
            else if (medals[i].gold == medals[targetCountry].gold) {
                if (medals[i].silver > medals[targetCountry].silver) {
                    rank++;
                }
                else if (medals[i].silver == medals[targetCountry].silver) {
                    if (medals[i].bronze > medals[targetCountry].bronze) {
                        rank++;
                    }
                }
            }
        }
    }

    printf("%d", rank + 1);
}