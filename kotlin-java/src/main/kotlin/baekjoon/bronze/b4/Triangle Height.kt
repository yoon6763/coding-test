package baekjoon.bronze.b4

fun main() {
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toDouble() }
        println("The height of the triangle is %.2f units".format((a * 2) / b))
    }
}