package baekjoon.bronze.b3

fun main() {
    val x = mutableListOf<Int>()
    val y = mutableListOf<Int>()
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        x.add(a)
        y.add(b)
    }
    println(((x.maxOrNull()!! - x.minOrNull()!!) + (y.maxOrNull()!! - y.minOrNull()!!)) * 2)
}
