package baekjoon.bronze.b3

fun main() {
    val (k, n) = readln().split(" ").map { it.toLong() }

    if (n == 1L) {
        println(-1)
        return
    }

    var ans = (k * n) / (n - 1)
    if ((k * n) % (n - 1) != 0L) ans += 1
    println(ans)
}
