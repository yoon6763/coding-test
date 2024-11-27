package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var maxCakes = Int.MAX_VALUE

    repeat(n) {
        val (required, available) = readln().split(" ").map { it.toInt() }
        maxCakes = minOf(maxCakes, available / required)
    }

    println(maxCakes)
}