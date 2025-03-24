package baekjoon.bronze.b4

fun main() {
    val (n, h) = readln().split(" ").map { it.toInt() }
    var total = 0

    readln().split(" ").map { it.toInt() }.forEach {
        if (h >= it) total++
    }
    println(total)
}
