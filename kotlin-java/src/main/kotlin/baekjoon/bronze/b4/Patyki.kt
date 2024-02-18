package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
    if (a == b && b == c) {
        println(2)
    } else if (a * a + b * b == c * c) {
        println(1)
    } else {
        println(0)
    }
}