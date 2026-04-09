package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toLong()
        println("ABCBCDCDADAB"[((n - 1) % 12).toInt()])
    }
}