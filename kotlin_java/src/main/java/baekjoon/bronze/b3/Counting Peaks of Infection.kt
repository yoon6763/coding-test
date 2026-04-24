package baekjoon.bronze.b3

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        val v = readln().split(" ").map { it.toInt() }
        var count = 0

        for (i in 1 until n - 1) {
            if (v[i] > v[i - 1] && v[i] > v[i + 1]) count++
        }
        println(count)
    }
}