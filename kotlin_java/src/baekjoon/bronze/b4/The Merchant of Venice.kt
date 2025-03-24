package baekjoon.bronze.b4

fun main() {
    for (i in 1..readln().toInt()) {
        val (n, s, d) = readln().split(" ").map { it.toInt() }
        var ans = 0

        repeat(n) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            if (s * d >= a) ans += b
        }

        println("Data Set $i:\n$ans\n")
    }
}
