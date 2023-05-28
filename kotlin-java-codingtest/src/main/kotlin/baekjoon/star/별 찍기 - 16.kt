package baekjoon.star

fun main() {
    val n = readln().toInt()

    repeat(n) {
        repeat(n - it - 1) {
            print(" ")
        }
        repeat(it * 2 + 1) {
            if (it % 2 == 0) print("*")
            else print(" ")
        }
        println()
    }
}