package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(if (n.toString(2).count { it == '1' } % 2 == m) "Valid" else "Corrupt")
}