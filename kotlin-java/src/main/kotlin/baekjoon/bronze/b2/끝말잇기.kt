package baekjoon.bronze.b2

fun main() {
    readln()
    println(if (readln().split(" ").map { it[0] }.distinct().size == 1) 1 else 0)
}