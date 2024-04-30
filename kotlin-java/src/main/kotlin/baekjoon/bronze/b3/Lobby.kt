package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (all, my, other) = readLine().split(" ").map { it.toInt() }
        if (all == 0 && my == 0 && other == 0) break

        val middle = all - my - other

        if (middle + my <= all / 2) {
            println(-1)
        } else {
            println(maxOf(0, all / 2 - my + 1))
        }
    }
}