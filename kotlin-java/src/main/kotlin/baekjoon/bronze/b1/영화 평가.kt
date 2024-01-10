package baekjoon.bronze.b1

fun main() {
    val (n, l, h) = readln().split(" ").map { it.toInt() }
    print(readln().split(" ").map { it.toInt() }.sorted().subList(l, n - h).average())
}