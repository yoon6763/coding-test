package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()

    repeat(n) { sb.append("@".repeat(3 * n)).append(" ".repeat(n)).append("@".repeat(n)).append("\n") }
    repeat(n * 3) { sb.append("@".repeat(n)).append(" ".repeat(n)).append("@".repeat(n)).append(" ".repeat(n)).append("@".repeat(n)).append("\n") }
    repeat(n) { sb.append("@".repeat(n)).append(" ".repeat(n)).append("@".repeat(n * 3)).append("\n") }

    print(sb)
}