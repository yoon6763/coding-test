#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main() {
    int n;
    scanf("%d", &n); //테스트 케이스 갯수 입력 

    for (int i = 0; i < n; i++) { // 테스트 케이스 갯수만큼 for문 돌리기
        int arr[80];
        scanf("%s", &arr);  //O,X 문자열 입력

        int cnt = 0; //O가 몇개 나왔는지 기억하는 변수
        int sum = 0; //각 문자열에 대해 계산한 결과

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