package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    println(List(readln().toInt()) {
        val input = readln().split(" ")
        Pair(input[0].toInt(), input[1])
    }.sortedBy { -it.first }[0].second)
}
