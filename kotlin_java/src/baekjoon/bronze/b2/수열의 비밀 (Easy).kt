package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val (p, q, r, s) = readln().split(" ").map { it.toInt() }
    val a = readln().toInt()

    val arr = IntArray(n + 1)

    for (i in 1..n) {
        arr[i] = when {
            i == 1 -> a
            i % 2 == 0 -> (p * arr[i / 2]) + q
            else -> (r * arr[i / 2]) + s
        }
    }

    println(arr.sum())
}
