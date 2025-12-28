package baekjoon.bronze.b4

fun main() {
    val (y,c,p) = readln().split(" ").map { it.toInt() }
    print(minOf(y, c / 2, p))
}
