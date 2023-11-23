package baekjoon.bronze.b4

fun main() {
    val sb = StringBuilder()
    while (true) {
        val n = readln().toInt()
        if (n == 0) break
        repeat(n) {
            sb.append("*".repeat(it + 1)).appendLine()
        }
    }
    print(sb)
}