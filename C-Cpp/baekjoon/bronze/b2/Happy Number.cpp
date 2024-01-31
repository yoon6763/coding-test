#include <iostream>
#include <unordered_set>

int calculateSum(int n) {
    int sum = 0;
    while (n > 0) {
        sum += (n % 10) * (n % 10);
        n /= 10;
    }
    return sum;
}

std::string isHappy(int n) {
    std::unordered_set<int> seen;
    while (true) {
        n = calculateSum(n);
        if (n == 1) {
            return "HAPPY";
        }
        if (seen.find(n) != seen.end()) {
            return "UNHAPPY";
        }
        seen.insert(n);
    }
}

int main() {
    int n;
    std::cin >> n;
    std::cout << isHappy(n) << std::endl;
    return 0;
}
