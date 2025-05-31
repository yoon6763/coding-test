package baekjoon.bronze.b4

fun main() {
    val (h, l, a, b) = readln().split(" ").map { it.toInt() }
    val halfA = a / 2.0
    val halfB = b / 2.0
    if (halfA <= h && b <= l || halfB <= h && a <= l) {
        println("YES")
    } else {
        println("NO")
    }
}