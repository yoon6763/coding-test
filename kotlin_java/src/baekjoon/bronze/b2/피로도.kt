package baekjoon.bronze.b2

fun main() {
    val (A, B, C, M) = readln().split(" ").map { it.toInt() }

    var p = 0
    var value = 0

    repeat(24) {
        if (p + A <= M) {
            p += A
            value += B
        } else {
            if (p - C >= 0) {
                p -= C
            } else {
                p = 0
            }
        }
    }

    println(value)
}
