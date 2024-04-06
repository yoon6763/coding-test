package baekjoon.bronze.b2

fun main() =with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val line = readLine()
        if (line == "#") break

        sb.appendLine(line.split(" ").map { it.reversed() }.joinToString(" "))
    }
    print(sb)
}