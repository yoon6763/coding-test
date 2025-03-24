package baekjoon.silver.s4

fun main() {
    readln()
    val set = readln().split(" ").toSet() - readln().split(" ").toSet()
    println(set.size)
    print(set.toList().map { it.toInt() }.sorted().joinToString(" "))
}