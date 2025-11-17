package baekjoon.bronze.b5

fun main() {
    while (true) {
        val ns = readlnOrNull() ?: break
        val (n, s) = ns.split(" ").map { it.toInt() }
        println(s / (n + 1))
    }
}