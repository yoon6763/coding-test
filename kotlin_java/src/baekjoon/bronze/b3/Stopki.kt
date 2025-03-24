package baekjoon.bronze.b3

fun main() {
    var (betweenDistance, len1, len2) = readln().split(" ").map { it.toInt() }
    betweenDistance %= (len1 + len2)
    while (true) {
        betweenDistance -= len1
        if (betweenDistance < 0) {
            println(1)
            break
        }
        betweenDistance -= len2
        if (betweenDistance < 0) {
            println(0)
            break
        }
    }
}