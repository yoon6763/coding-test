package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val sb = StringBuilder()
    repeat(n) {
        sb.append("@".repeat(n))
        sb.append(" ".repeat(n * 3))
        sb.append("@".repeat(n)).append("\n")
    }

    repeat(n) {
        sb.append("@".repeat(n * 5)).append("\n")
    }

    repeat(n) {
        sb.append("@".repeat(n))
        sb.append(" ".repeat(n * 3))
        sb.append("@".repeat(n)).append("\n")
    }

    repeat(n) {
        sb.append("@".repeat(n * 5)).append("\n")
    }

    repeat(n) {
        sb.append("@".repeat(n))
        sb.append(" ".repeat(n * 3))
        sb.append("@".repeat(n)).append("\n")
    }

    print(sb)
}