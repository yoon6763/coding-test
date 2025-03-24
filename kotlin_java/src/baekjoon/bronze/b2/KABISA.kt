package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    println(readln().split(",").map { it.trim().toInt() }.filter { it % 400 == 0 || (it % 4 == 0 && it % 100 != 0) }.joinToString(" "))
}
