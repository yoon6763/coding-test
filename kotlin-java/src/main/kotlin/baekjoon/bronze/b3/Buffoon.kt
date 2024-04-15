package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val t = readln().toInt()
    val n = readln().toInt()

    repeat(t - 1) {
        if (n < readln().toInt()) {
            println("N")
            return@with
        }
    }
    println("S")
}