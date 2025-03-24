package baekjoon.bronze.b3

fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()

    repeat(n) { sb.append("@".repeat(5 * n)).append("\n") }
    repeat(n) { sb.append("@".repeat(n)).append("\n") }
    repeat(n) { sb.append("@".repeat(5 * n)).append("\n") }
    repeat(2 * n) { sb.append("@".repeat(n)).append("\n") }

    print(sb)
}