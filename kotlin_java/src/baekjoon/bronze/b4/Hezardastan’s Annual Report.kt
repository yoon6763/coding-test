package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    var ans = 0
    for (i in 0 until n) {
        ans += arr[i]
        if (arr[i] % 2 == 1 && i != n - 1) ans += 1
    }

    println((ans + 1) / 2)
}
