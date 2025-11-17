package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    when {
        a == b && b == c -> println("*")
        a == b -> println("C")
        a == c -> println("B")
        b == c -> println("A")
    }
}