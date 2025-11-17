package baekjoon.bronze.b2

fun main() {
    val n = readln().toLong()
    var i = 1L
    var ans = 0
    while (i * i <= n) {
        if (n % i == 0L) if (i * i == n) ans++ else ans += 2
        i++
    }
    println(ans)
}