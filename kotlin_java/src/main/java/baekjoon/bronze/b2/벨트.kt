package baekjoon.bronze.b2

fun main() {
    var ans = 1
    var flag = true

    repeat(readln().toInt()) {
        val (a, b, s) = readln().split(" ").map { it.toInt() }
        ans = (ans / a) * b
        if (s == 1) flag = !flag
    }

    println("${if (flag) 0 else 1} $ans")
}