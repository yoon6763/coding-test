package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n) { it + 1 }

    repeat(m) {
        val (i, j) = readLine().split(" ").map { it.toInt() - 1 }
        arr.reverse(i, j)
    }

    print(arr.joinToString(" "))
}