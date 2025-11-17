package baekjoon.silver.s5

fun main() {
    val (e, s, m) = readln().split(" ").map { it.toInt() }
    var (a, b, c) = listOf(1, 1, 1)
    var ans = 1
    while (true) {
        if (a == e && b == s && c == m) break
        a++
        b++
        c++
        ans++
        if (a == 16) a = 1
        if (b == 29) b = 1
        if (c == 20) c = 1
    }
    println(ans)
}