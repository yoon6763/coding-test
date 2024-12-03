package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    println((1..n).filter { n % it == 0 }.sum())
}
