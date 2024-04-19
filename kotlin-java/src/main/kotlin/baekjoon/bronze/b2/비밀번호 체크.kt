package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val words = "+_)(*&^%\\$#@!./,;{}"
    repeat(readLine().toInt()) {
        readLine()
        val line = readLine()
        if (line.any { it.isUpperCase() } && line.any { it.isLowerCase() } && line.any { it.isDigit() } && line.any { words.contains(it) } && line.length >= 12) sb.append("valid\n")
        else sb.append("invalid\n")
    }
    print(sb)
}