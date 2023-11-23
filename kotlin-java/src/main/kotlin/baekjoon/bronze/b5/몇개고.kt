package baekjoon.bronze.b5

fun main() {
    val (t, s) = readln().split(" ").map { it.toInt() }
    if(t !in 12 .. 16 || s == 1) println(280) else println(320)
}
