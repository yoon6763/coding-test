package baekjoon.bronze.b3

fun main() {
    val arr = List(readln().toInt()) { readln().split(" ").let { it[0] to it[1].toInt() } }
    val a1 = arr.first { it.first == "jinju" }.second
    println("$a1\n${arr.count { it.second > a1 }}")
}