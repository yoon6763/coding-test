package baekjoon.bronze.b3

fun main() {
    var (n, k) = readln().split(" ").map { it.toInt() }
    var a = 1
    var answer = 0

    for (i in 1..<n) {
        a *= 2
    }

    while (k >= a) {
        k -= a
        answer++
    }

    println(answer)
}
