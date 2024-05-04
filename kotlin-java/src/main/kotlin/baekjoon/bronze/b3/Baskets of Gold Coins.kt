package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val str = readLine() ?: break
        val (n, w, d, sum) = str.split(" ").map { it.toLong() }
        val ans = (sum - n * (n - 1) / 2 * w) / d
        if (ans == 0L) println(n)
        else println(-ans)
    }
}