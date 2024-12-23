package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val str = readln()

    println(
        str.indices
        .takeWhile { it + 2 < str.length }
        .count { str.substring(it, it + 3) == "WOW" })
}
