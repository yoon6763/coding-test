package baekjoon.bronze.b5

fun main() {
    val n = readln().toInt()
    val odd = readln().split(" ").count { it.toInt() % 2 == 1 }
    if (n - odd > odd) {
        println("Happy")
    } else {
        println("Sad")
    }
}