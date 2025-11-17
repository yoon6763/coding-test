package baekjoon.bronze.b3

fun main() {
    while (true) {
        val n = readln().toLong()
        if (n == 0L) break
        println(
            when {
                n <= 1000000 -> n
                n <= 5000000 -> n * 0.9
                else -> n * 0.8
            }.toLong()
        )
    }
}