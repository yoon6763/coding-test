package baekjoon.bronze.b3

fun main() {
    var tc = 1
    while (true) {
        val s = readln().toLong()
        if (s == 0L) break
        val size1 = (s + 1) / 2
        val size2 = (3 * size1 + 1) / 2
        val lines = (size2 + 61) / 62
        val floppies = (lines + 30000 - 1) / 30000

        println("File #$tc")
        println("John needs $floppies floppies.")
        println()

        tc++
    }
}