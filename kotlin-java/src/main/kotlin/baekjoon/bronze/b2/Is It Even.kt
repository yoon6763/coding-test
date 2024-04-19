package baekjoon.bronze.b2

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var cnt = 0
    repeat(n) {
        var cur = readln().toInt()
        while (cur % 2 == 0) {
            cnt++
            cur /= 2
        }
    }
    println(if (cnt >= k) 1 else 0)
}
