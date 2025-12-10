package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val (E, N) = readln().split(" ").map { it.toInt() }
        println((1..N).count { readln().toInt() > E })
    }
}
