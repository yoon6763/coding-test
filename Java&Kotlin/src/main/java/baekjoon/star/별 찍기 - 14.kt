package baekjoon.star

fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        repeat(n) {
            print("*")
        }
        println()
    }
}