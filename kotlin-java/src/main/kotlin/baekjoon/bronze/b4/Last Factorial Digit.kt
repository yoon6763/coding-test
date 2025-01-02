package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    val n = readln().toInt()
    println(if (n < 5) (1..n).fold(1) { acc, i -> acc * i } % 10 else 0)
}
