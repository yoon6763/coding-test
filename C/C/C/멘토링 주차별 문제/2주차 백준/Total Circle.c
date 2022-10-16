#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    int p[1000][2];
    int q[1000][2];

    long long int max = -1;

    for (int i = 0; i < n; i++) scanf("%d %d", &p[i][0], &p[i][1]);

    for (int i = 0; i < m; i++) {
        scanf("%d %d", &q[i][0], &q[i][1]);

        long long int radius = 0;

        for (int j = 0; j < n; j++) {
            long long int n_radius = pow((q[i][0] - p[j][0]), 2) + pow((q[i][1] - p[j][1]), 2);
            if (n_radius > radius) radius = n_radius;
        }

        if (radius > max) max = radius;
    }

    printf("%lld", max);
}