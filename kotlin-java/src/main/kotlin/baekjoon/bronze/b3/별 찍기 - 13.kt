package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()

    for (i in n - 1 downTo 1) {
        repeat(n - i) {
            print("*")
        }
        println()
    }
    for (i in 1..n) {
        repeat(n - i + 1) {
            print("*")
        }
        println()
    }
}