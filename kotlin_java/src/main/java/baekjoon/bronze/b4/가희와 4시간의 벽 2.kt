package baekjoon.bronze.b4

fun main() {
    val s = readln().toInt()
    val (ma, f, mb) = readln().split(" ").map { it.toInt() }

    if (s <= ma + f + mb || s <= 240) {
        println("high speed rail")
    } else {
        println("flight")
    }
}
