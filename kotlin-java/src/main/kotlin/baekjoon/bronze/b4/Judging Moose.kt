package baekjoon.bronze.b4

fun main() {
    val (l, r) = readln().split(" ").map { it.toInt() }
    println(if (l == 0 && r == 0) "Not a moose" else if (l == r) "Even ${l + r}" else "Odd ${maxOf(l, r) * 2}")
}