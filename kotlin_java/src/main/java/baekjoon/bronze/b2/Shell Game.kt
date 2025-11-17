package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln().split(" ").map { it.toInt() } }

    var result = 0

    for (k in 1..3) {
        var cur = k
        var max = 0
        for ((a, b, g) in arr) {
            cur = when (cur) {
                a -> b
                b -> a
                else -> cur
            }

            if (cur == g) max++
        }
        if (max > result) result = max
    }

    println(result)
}
