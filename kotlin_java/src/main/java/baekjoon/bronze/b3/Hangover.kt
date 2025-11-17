package baekjoon.bronze.b3

fun main() {
    while (true) {
        val c = readln().toDouble()
        if (c == 0.0) break

        var length = 0.0
        var cnt = 0

        for (i in 1..Int.MAX_VALUE) {
            length += 1.0 / (i + 1)
            if (length >= c) {
                cnt = i
                break
            }
        }
        println("$cnt card(s)")
    }
}