package baekjoon.bronze.b1

fun main() = repeat(readln().toInt()) {
    val (s, e) = readln().split(" ").map { it.toInt() }
    println(Array(e - s + 1) { (s + it).toString().toCharArray().count { it == '0' } }.sum())
}