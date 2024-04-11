package baekjoon.bronze.b2

fun main() {
    val (a, b, c, n) = readln().split(" ").map { it.toInt() }
    var answer = 0

    for (i in 0..n / a) {
        for (j in 0..n / b) {
            for (k in 0..n / c) {
                if (a * i + b * j + c * k == n) {
                    answer++
                    break
                }
            }
        }
    }
    print(if (answer == 0) "0" else "1")
}
