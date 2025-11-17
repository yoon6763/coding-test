package baekjoon.bronze.b1

fun main() = repeat(readln().toInt()) {
    repeat(readln().split(" ").map { it.toInt() }[0]) {
        println(readln().reversed())
    }
}