#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main() {
    int n;
    scanf("%d", &n); //�׽�Ʈ ���̽� ���� �Է� 

    for (int i = 0; i < n; i++) { // �׽�Ʈ ���̽� ������ŭ for�� ������
        int arr[80];
        scanf("%s", &arr);  //O,X ���ڿ� �Է�

        int cnt = 0; //O�� � ���Դ��� ����ϴ� ����
        int sum = 0; //�� ���ڿ��� ���� ����� ���

        for (int j = 0; j < strlen(arr); j++) {
            if (arr[j] == 'O' - 65) {
                cnt++;
                sum += cnt;
            }
            else if (arr[j] == 'X' - 65) {
                cnt = 0;
            }
        }

        printf("%d\n", sum);
    }

    return 0;
}