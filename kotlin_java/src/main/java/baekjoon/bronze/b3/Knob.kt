package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var cnt = 0
    var a = 0
    var b = 0

    repeat(n) {
        val (c, d) = readLine().split(" ").map { it.toInt() }

        if (it > 0) {
            if (a == c && a != 0) cnt++
            if (b == d && b != 0) cnt++
        }
        if (c == d && c != 0) cnt++

        a = c
        b = d
    }

    println(cnt)
}
