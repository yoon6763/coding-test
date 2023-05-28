package baekjoon.bronze.b5

fun main() {
    while (true) {
        val layer = readln().toInt()
        if (layer == 0) break

        println(Array(layer + 1) { it }.sum())
    }
}