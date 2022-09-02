package baekjoon.bronze.b4

fun main() {
    readLine()!!.split(" ").map { it.toInt() }.sorted().forEach { print("$it ") }
}