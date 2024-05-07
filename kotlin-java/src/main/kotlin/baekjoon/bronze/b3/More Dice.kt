package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        sb.appendLine("Case ${it + 1}:")
        val n = readLine().toInt()
        for (i in 1..6) {
            for (j in i..6) {
                if (i + j == n) sb.appendLine("(${i},${j})")
            }
        }
    }
    print(sb)
}