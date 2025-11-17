package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }

    var diet = 0

    for (i in n - 1 downTo 0) {
        diet += arr[i]
        if (diet >= m) {
            println(i + 1)
            return
        }
    }

    println(-1)
}