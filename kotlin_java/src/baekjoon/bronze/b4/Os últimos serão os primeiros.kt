package baekjoon.bronze.b4

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val n = readLine().toInt()
        if (n == 0) break
        List(n) { readLine().toInt() }.reversed().forEach { sb.appendLine(it) }
        sb.appendLine("0")
    }
    print(sb)
}