#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {

	long long dp[91] = {0};
	int n;
	scanf("%d", &n);
	dp[1] = 1;
	dp[2] = 1;

	for (int i = 2; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}
	printf("%lld", dp[n]);

	return 0;
}