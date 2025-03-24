package baekjoon.bronze.b4

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        println("$n is ${if (n % 2 == 0) "even" else "odd"}")
    }
}