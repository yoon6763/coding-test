package baekjoon.bronze.b3

fun main() {
    repeat(readLine()!!.toInt()) {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val result = if (n >= 12 && m >= 4) 11 * m + 4 else -1
        println(result)
    }
}
