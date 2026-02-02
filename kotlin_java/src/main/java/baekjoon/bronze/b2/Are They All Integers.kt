package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toDouble() }

    for (i in 0..<n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                val d1 = (arr[i] - arr[j]) / arr[k]
                val d2 = (arr[j] - arr[k]) / arr[i]
                val d3 = (arr[k] - arr[i]) / arr[j]

                if (listOf(d1, d2, d3).any { it % 1.0 != 0.0 }) {
                    println("no")
                    return
                }
            }
        }
    }

    println("yes")
}
