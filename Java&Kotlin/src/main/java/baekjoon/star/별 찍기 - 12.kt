package baekjoon.star

fun main() {
    val n = readln().toInt()

    for (i in 1..n) {
        repeat(n - i) {
            print(" ")
        }
        repeat(i) {
            print("*")
        }
        println()
    }

    for (i in n - 1 downTo 1) {
        repeat(n - i) {
            print(" ")
        }
        repeat(i) {
            print("*")
        }
        println()
    }
}