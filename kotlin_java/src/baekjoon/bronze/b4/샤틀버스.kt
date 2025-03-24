package baekjoon.bronze.b4

fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }

    if (x > y) {
        println(x + y)
    } else {
        println(y - x)
    }
}
