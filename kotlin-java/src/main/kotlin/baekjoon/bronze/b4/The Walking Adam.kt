package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    val line = readln()
    val index = line.indexOf("D")
    if (index == -1) println(line.length) else println(index)
}