package baekjoon.bronze.b3

fun main() {
    val K = readln().toInt()

    repeat(K) { t ->
        val (n, W, E) = readln().split(" ").map { it.toInt() }
        var total = 0L

        repeat(n) {
            val (Lww, Lwe, Lew, Lee) = readln().split(" ").map { it.toInt() }

            val west = W.toLong() * Lww + E.toLong() * Lew
            val east = W.toLong() * Lwe + E.toLong() * Lee

            total += maxOf(west, east)
        }

        println("Data Set ${t + 1}:")
        println(total)
        println()
    }
}