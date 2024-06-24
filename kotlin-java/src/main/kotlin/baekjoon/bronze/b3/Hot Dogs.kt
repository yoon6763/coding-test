package baekjoon.bronze.b3

fun main() {
    while (true) {
        try {
            val (h, p) = readln().split(" ").map { it.toDouble() }
            println("%.2f".format(h / p))
        } catch (e: Exception) {
            break
        }
    }
}
