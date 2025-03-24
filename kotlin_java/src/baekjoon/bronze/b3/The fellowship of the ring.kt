package baekjoon.bronze.b3

fun main() {
    val (w, n, p) = readln().split(" ").map { it.toInt() }
    println(readln().split(" ").map { it.toInt() }.count { it in w..n })
}
