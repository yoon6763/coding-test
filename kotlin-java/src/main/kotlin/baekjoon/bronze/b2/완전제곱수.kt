package baekjoon.bronze.b2

fun main() {
    val (n, m) = Array(2) { readln().toInt() }
    var ans = 0
    var min = Int.MAX_VALUE

    for (i in n..m) {
        val sqrt = Math.sqrt(i.toDouble()).toInt()
        if (sqrt * sqrt == i) {
            ans += i
            min = minOf(min, i)
        }
    }
    if (ans == 0) println(-1)
    else println("$ans\n$min")
}