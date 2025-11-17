package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    println(if (a + b == c || a + c == b || b + c == a) "1" else if (a * b == c || a * c == b || b * c == a) "2" else "3")
}
