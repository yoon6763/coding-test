package baekjoon.bronze.b2

fun main() {
    val (a, b, c) = readln().split(" ")
    val target = readln().toInt()

    val arr = listOf(a + b + c, a + c + b, b + a + c, b + c + a, c + a + b, c + b + a).map { it.toInt() }.sorted()
    println(arr.indexOf(target) + 1)
}