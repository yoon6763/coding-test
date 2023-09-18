#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	long long int n, result = 0, idx = 1;
	scanf("%lld", &n);

	for (; ;) {
		result += idx;
		if (result > n) break;
		idx++;
	}
	printf("%lld", idx - 1);
}