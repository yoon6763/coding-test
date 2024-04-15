package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val line = readLine()
        if (line == "END") break
        val trim = line.filter { it != ' ' }
        if (trim.toCharArray().toSet().size == trim.length) sb.appendLine(line)
    }
    print(sb)
}