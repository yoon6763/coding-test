package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    println(readln().toInt() + Array(readln().toInt()) { readln().split(" ").map(String::toInt).let { it[0] * it[1] } }.sum())
}