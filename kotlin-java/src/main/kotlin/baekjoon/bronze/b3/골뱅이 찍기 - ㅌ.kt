package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    repeat(n) { sb.append("@".repeat(5 * n)).append("\n") }
    repeat(n) { sb.append("@".repeat(n)).append("\n") }
    repeat(n) { sb.append("@".repeat(5 * n)).append("\n") }
    repeat(n) { sb.append("@".repeat(n)).append("\n") }
    repeat(n) { sb.append("@".repeat(5 * n)).append("\n") }

    print(sb)
}