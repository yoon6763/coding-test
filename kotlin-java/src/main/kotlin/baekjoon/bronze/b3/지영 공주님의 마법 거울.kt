package baekjoon.bronze.b3

fun main() {
    val arr = Array(readln().toInt()) { readln() }
    when (readln().toInt()) {
        1 -> arr.forEach { println(it) }
        2 -> arr.forEach { println(it.reversed()) }
        3 -> arr.reversed().forEach { println(it) }
    }
}