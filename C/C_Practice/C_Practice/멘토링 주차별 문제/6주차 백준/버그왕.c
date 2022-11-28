#include <stdio.h>
#include <string.h>

int main() {
    char str[101];
    char bug[] = "BUG";

    while (fgets(str, 101, stdin) != NULL) {

        while (strstr(str, bug) != NULL) {
            strcpy(strstr(str, bug), strstr(str, bug) + 3);

        }

        printf("%s", str);
    }
}
