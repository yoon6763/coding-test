#include <stdio.h>
#include <stdlib.h>

int main() {
    while (1) {
        int n, m, ptr1, ptr2;
        scanf("%d %d", &n, &m);

        if (n == 0 && m == 0) break;

        int* arr1 = (int*)malloc(n * sizeof(int));
        int* arr2 = (int*)malloc(m * sizeof(int));

        for (int i = 0; i < n; i++) {
            scanf("%d", &arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            scanf("%d", &arr2[i]);
        }

        ptr1 = ptr2 = 0;
        int cnt = 0;

        // ���� ptr�� �迭�� ���� ���������� �ݺ�
        while (ptr1 < n && ptr2 < m) {
            // ptr1���� ptr2�� ũ�� ptr1�� +1
            if (arr1[ptr1] < arr2[ptr2]) {
                ptr1++;
            }
            // ptr1�� ptr2���� ũ�� ptr2�� +1
            else if (arr1[ptr1] > arr2[ptr2]) {
                ptr2++;
            }
            // ���� ptr�� ������ ������� ī��Ʈ�� �ϰ�, ���� ptr�� +1
            else {
                cnt++;
                ptr1++;
                ptr2++;
            }
        }
        printf("%d\n", cnt);
    }
}