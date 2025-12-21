package baekjoon.bronze.b5

fun main() {
    val n = readln().toLong()
    if (n * n <= 100000000L) {
        println("Accepted")
    } else {
        println("Time limit exceeded")
    }
}
