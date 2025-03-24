package baekjoon.bronze.b3

fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    val r = readln().toInt()

    println("${x - r} ${y + r}")
    println("${x + r} ${y + r}")
    println("${x + r} ${y - r}")
    println("${x - r} ${y - r}")
}
