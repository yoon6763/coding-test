package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val (a, n) = readln().split(" ").map { it.toLong() }
    val parse = a.toString(n.toInt())
    println(if (parse == parse.reversed()) 1 else 0)
}
