package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    var (a, b, c) = readln().split(" ").map { it.toInt() }
    println("Data set: $a $b $c")
    repeat(c) { if (a >= b) a /= 2 else b /= 2 }
    println("${if (a > b) "$a $b" else "$b $a"}\n")
}