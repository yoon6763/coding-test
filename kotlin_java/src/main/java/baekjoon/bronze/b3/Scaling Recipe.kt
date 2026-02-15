package baekjoon.bronze.b3

fun main() {
    val (n, x, y) = readln().split(" ").map { it.toLong() }

    repeat(n.toInt()) {
        val a = readln().toLong()
        println(a * y / x)
    }
}
