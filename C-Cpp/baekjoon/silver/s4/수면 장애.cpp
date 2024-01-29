#include <iostream>
#include <string>

int main() {
    int n;
    std::cin >> n;

    int index = 0;

    while (n > 0) {
        index++;
        std::string parsed = std::to_string(index);
        n -= parsed.length();
        if (n <= 0) {
            std::cout << parsed[parsed.length() + n - 1] << std::endl;
            break;
        }
    }

    return 0;
}
