package baekjoon.bronze.b1

fun main() {
    val sb = StringBuilder()
    while (true) {
        val line = readlnOrNull() ?: break
        sb.append(line)
    }
    println(sb.toString().split(",").sumOf { it.toInt() })
}