package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    println("$n ${(1..n).count { n % it == 0 }}")
}