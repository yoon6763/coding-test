package baekjoon.silver.s5

fun main() {
    var ans = 0
    repeat(readln().toInt()) {
        val (c, k) = readln().split(" ").map { it.toInt() }
        ans += c * k
    }
    println(ans)
}