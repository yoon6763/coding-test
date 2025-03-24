package baekjoon.bronze.b4

fun main() {
    readln()
    print(readln().split(" ").map { it.toInt() }.map {
        when {
            it == 300 -> 1
            it >= 275 -> 2
            it >= 250 -> 3
            else -> 4
        }
    }.joinToString(" "))
}