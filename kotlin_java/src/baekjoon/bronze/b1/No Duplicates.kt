package baekjoon.bronze.b1

fun main() {
    val line = readln().split(" ")
    println(if (line.size == line.toSet().size) "yes" else "no")
}