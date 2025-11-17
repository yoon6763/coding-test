package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) { sb.append(readLine().reversed()).append("\n") }
    print(sb)
}