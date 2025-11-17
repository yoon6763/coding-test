package baekjoon.bronze.b3

fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }
    var idx = 1
    while (true) {
        if (y * idx - x * idx >= y) {
            println(idx)
            break
        }
        idx++
    }
}
