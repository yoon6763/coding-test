package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val o = readln().toInt()
    val a = o / (n - 1)
    val b = o + a

    if (o - a * (n - 1) == 0) println("${b - 1} $b")
    else println("$b $b")
}