package baekjoon.bronze.b3

fun main() {
    while (true) {
        val line = readlnOrNull() ?: break
        val (c, d) = line.split(" ").map { it.toInt() }.apply { if (this.all { it == 0 }) return }
        println(
            minOf(
                c * 30 + d * 40,
                c * 35 + d * 30,
                c * 40 + d * 20
            )
        )
    }
}
