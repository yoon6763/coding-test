package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val line = readln().split(" ").map { it.toInt() }.sorted().slice(1..3)
    if (line[2] - line[0] >= 4) println("KIN")
    else println(line.sum())
}