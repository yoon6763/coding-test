package baekjoon.bronze.b1

fun main() {
    readln()
    println(readln().map { if (it.isLetter()) " " else it }.joinToString("").trim().split(" ").filter { it.isNotEmpty() }.sumOf { it.toLong()})
}