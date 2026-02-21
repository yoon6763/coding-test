package baekjoon.bronze.b3

fun main() {
    val t = readln().toInt()

    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val sum = IntArray(n)

        repeat(m) {
            val votes = readln().split(" ").map { it.toInt() }
            for (i in 0 until n) {
                sum[i] += votes[i]
            }
        }

        var maxIdx = 0
        for (i in 1 until n) {
            if (sum[i] <= sum[maxIdx]) continue
            maxIdx = i
        }

        println(maxIdx + 1)
    }
}