package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val counts = readln().split(" ").map { it.toInt() }

    var maxTrue = -1

    for (i in 0..<(n + 1)) {
        val trueCount = counts.count { it == i }

        if (trueCount == i) {
            maxTrue = maxOf(maxTrue, i)
        }
    }

    println(maxTrue)
}
