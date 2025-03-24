package baekjoon.bronze.b3

fun main() {
    val now = readln().toInt()
    val correct = readln().toInt()
    val res = correct - now
    println(if (res > 180) res - 360 else if (res <= -180) res + 360 else res)
}