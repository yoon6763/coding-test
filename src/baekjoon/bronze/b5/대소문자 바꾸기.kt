package baekjoon.bronze.b5

fun main() {
    val line = readLine()!!
    val sb = StringBuilder()
    for (c in line) sb.append(if (c.isUpperCase()) c.lowercase() else c.uppercase())

    println(sb.toString())
}