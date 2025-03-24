package baekjoon.unrated.u0

fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        repeat(n) {
            print("*")
        }
        println()
    }
}