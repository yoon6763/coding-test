package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val buckets = IntArray(1001)

    repeat(n) {
        val (s, t, b) = readln().split(" ").map { it.toInt() }
        for (time in s until t) buckets[time] += b
    }

    println(buckets.max())
}
