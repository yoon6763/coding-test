package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val input = readLine()
        if (input == "*") break
        sb.appendLine(if (input.replace(" ", "").toSet().size == 26) "Y" else "N")
    }
    print(sb)
}