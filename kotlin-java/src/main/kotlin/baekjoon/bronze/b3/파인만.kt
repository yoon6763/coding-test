package baekjoon.bronze.b3

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        var ans = 0
        for (i in 1..n) {
            ans += i * i
        }
        println(ans)
    }
}