package baekjoon.bronze.b4

fun main() {
    repeat(readln().toInt()) {
        repeat(readln().toInt()) {
            val arr = readln().split(" ").map { it.toInt() }
            println("${arr.sum()} ${arr[0] * arr[1]}")
        }
    }
}