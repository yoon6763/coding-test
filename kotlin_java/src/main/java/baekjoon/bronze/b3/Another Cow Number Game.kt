package baekjoon.bronze.b3

fun main() {
    var n = readln().toLong()
    var score = 0
    while (n != 1L) {
        if (n % 2 == 1L) n = 3 * n + 1 else n /= 2
        score++
    }
    println(score)
}