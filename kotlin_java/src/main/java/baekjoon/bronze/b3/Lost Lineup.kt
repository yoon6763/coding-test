package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val result = IntArray(n)

    result[0] = 1

    if (n > 1) {
        val d = readln().split(" ").map { it.toInt() }
        for (i in d.indices) {
            result[d[i] + 1] = i + 2
        }
    }

    println(result.joinToString(" "))
}