package baekjoon.bronze.b2

fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { false }

    repeat(q) {
        val (l, i) = readln().split(" ").map { it.toInt() }
        (l - 1..<n step i).forEach { arr[it] = true }
    }

    println(arr.count { !it })
}