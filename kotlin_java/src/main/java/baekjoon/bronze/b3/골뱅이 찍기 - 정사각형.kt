package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()
    sb.append("@".repeat(n + 2)).append("\n")
    repeat(n) { sb.append("@").append(" ".repeat(n)).append("@").append("\n") }
    sb.append("@".repeat(n + 2)).append("\n")
    print(sb)
}