package baekjoon.bronze.b3

fun main() {
    val n = readln().toLong()
    if (n % 2 != 0L) {
        println(0)
    } else {
        val sum = n * (n + 1L) / 2L
        if (sum % 2L != 0L) {
            println(1)
        } else {
            println(2)
        }
    }
}