package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        readLine()
        sb.append(readLine().split(" ").sumOf { it.toInt() }).append("\n")
    }
    print(sb)
}