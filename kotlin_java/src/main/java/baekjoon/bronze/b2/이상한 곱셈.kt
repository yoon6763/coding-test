package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ")
    var ans = 0L
    for (a in n) for (b in m) ans += (a - '0') * (b - '0')

    println(ans)
}