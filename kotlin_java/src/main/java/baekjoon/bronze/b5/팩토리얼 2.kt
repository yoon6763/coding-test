package baekjoon.bronze.b5

fun main() {
    var result = 1L
    for (i in 1..readln().toInt()) result *= i
    println(result)
}