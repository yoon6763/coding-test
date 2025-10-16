package baekjoon.bronze.b4

fun main() {
    val line = readln().split(" ").map { it.toInt() }
    val arr = List(3) { listOf("Joffrey", "Robb", "Stannis")[it] to line[it] * line[it + 3] }
    println(arr.filter { it.second == arr.maxOf { it.second } }.joinToString(" ") { it.first })
}
