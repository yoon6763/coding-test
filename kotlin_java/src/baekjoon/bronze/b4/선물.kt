package baekjoon.bronze.b4

fun main() {
    val (n, x) = readln().split(" ").map { it.toLong() }
    val arr = readln().split(" ").map { it.toLong() }

    var ans = Long.MAX_VALUE
    for (i in 0..<n.toInt() - 1) {
        ans = minOf(ans, arr[i + 1] * x + arr[i] * x)
    }
    println(ans)
}