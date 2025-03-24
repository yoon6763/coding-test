package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val string = readln().toCharArray()

    for (i in 0..<n / 2) {
        if (string[i] == '?' && string[n - 1 - i] == '?') {
            string[i] = 'a'
            string[n - 1 - i] = 'a'
        } else if (string[i] == '?') {
            string[i] = string[n - 1 - i]
        } else if (string[n - 1 - i] == '?') {
            string[n - 1 - i] = string[i]
        }
    }

    if (n % 2 == 1 && string[n / 2] == '?') string[n / 2] = 'a'

    println(string.joinToString(""))
}