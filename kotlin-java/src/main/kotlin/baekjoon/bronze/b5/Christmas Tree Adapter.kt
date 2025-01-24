package baekjoon.bronze.b5

fun main() {
    val a = readln().toInt()
    val (w, v) = readln().split(" ").map { it.toInt() }
    print(if (w / v >= a) 1 else 0)
}