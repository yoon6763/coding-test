package baekjoon.bronze.b4

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    repeat(readln().toInt()) {
        readln().toInt().let { println("$it ${if (it >= 1000) 1000 * a + (it - 1000) * b else it * a}") }
    }
}
