package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val str = readln()
    for (i in 0..<n - 1) {
        if (str[i + 1] == 'J') println(str[i])
    }
}