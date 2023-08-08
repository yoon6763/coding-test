#include <iostream>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unsigned long long int n, sum, tmp, res = 0;
    cin >> n;
    sum = (n - 1) * n / 2;
    for (int i = 0; i < n; i++)
    {
        cin >> tmp;
        res += tmp;
    }
    cout << res - sum;
}
