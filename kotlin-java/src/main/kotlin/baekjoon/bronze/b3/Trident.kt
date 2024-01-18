package baekjoon.bronze.b3

fun main() {
    val (t, s, h) = List(3) { readln().toInt() }
    repeat(t) { println("*" + " ".repeat(s) + "*" + " ".repeat(s) + "*") }
    println("*".repeat(3 + s * 2))
    repeat(h) { println(" ".repeat(1 + s) + "*") }
}
