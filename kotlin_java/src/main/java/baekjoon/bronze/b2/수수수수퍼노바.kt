package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val name = if (m <= 26) {
        ('A' + (m - 1)).toString()
    } else {
        val x = m - 27
        "${'a' + (x / 26)}${'a' + (x % 26)}"
    }

    println("SN $n$name")
}