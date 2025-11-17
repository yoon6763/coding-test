package baekjoon.bronze.b4

fun main() {
    val (p, q) = List(2) { readln().toInt() }
    if (p <= 50 && q <= 10) print("White")
    else if (q > 30) print("Red")
    else print("Yellow")
}