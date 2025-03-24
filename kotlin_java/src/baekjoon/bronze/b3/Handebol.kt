package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(List(n) { readln().split(" ").all { it != "0" } }.count { it })
}