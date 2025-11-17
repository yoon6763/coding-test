package baekjoon.bronze.b4

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val string = readLine()
        sb.append(string)
        if (string.last() != '.') sb.append(".")
        sb.append("\n")
    }
    print(sb)
}