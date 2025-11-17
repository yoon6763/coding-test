package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    println(if ((n + 1) % (n % 100) == 0) "Good" else "Bye")
}