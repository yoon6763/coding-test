package baekjoon.bronze.b4

fun main() {
    val (n, x) = readln().split(" ").map { it.toInt() }
    var ans = -1

    repeat(n) {
        val (s, t) = readln().split(" ").map { it.toInt() }
        if (s + t <= x && ans < s) ans = s
    }

    println(ans)
}
