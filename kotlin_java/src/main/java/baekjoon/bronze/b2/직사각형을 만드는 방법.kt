package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    var cnt = 0
    for (i in 1..n) {
        for (j in 1..i) {
            if (i * j <= n) cnt++
        }
    }
    println(cnt)
}
