package baekjoon.bronze.b3

fun main() {
    val (m, h) = readln().split(" ").map { it.toInt() }
    val n = readln().toInt()
    var ans = 0L

    repeat(n) {
        val (c, b) = readln().split(" ").map { it.toInt() }
        ans += maxOf(c.toLong() * m, b.toLong() * h)
    }

    println(ans)
}
