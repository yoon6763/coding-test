package baekjoon.bronze.b3

fun main() {
    readln()
    println(readln().split(" ").map { it.toInt() }.sumOf { if (it == 0) 2.0 else 1.0 / it })
}
