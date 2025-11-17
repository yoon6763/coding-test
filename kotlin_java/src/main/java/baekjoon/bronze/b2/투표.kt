package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().toInt() }
    val count = Array(n) { 0 }

    repeat(m) {
        val std = readln().toInt()
        for (i in 0 until n) {
            if (arr[i] <= std) {
                count[i]++
                break
            }
        }
    }

    println(count.indexOfFirst { it == maxOf(count.maxOrNull()!!) } + 1)
}