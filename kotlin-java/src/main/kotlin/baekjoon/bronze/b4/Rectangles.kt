package baekjoon.bronze.b4

fun main() {
    val (r, c) = List(2) { readln().toInt() }
    repeat(r) {
        println("*".repeat(c))
    }
}