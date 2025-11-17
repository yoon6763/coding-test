package baekjoon.bronze.b3

fun main() {
    val map = mapOf(0 to "J", 1 to "A", 2 to "B", 3 to "C", 4 to "D", 5 to "E", 6 to "F", 7 to "G", 8 to "H", 9 to "I", 10 to "Z")
    val mul = listOf(2, 7, 6, 5, 4, 3, 2)
    println(map[readln().toCharArray().map { it.digitToInt() }.mapIndexed { index, i -> i * mul[index] }.sum() % 11])
}