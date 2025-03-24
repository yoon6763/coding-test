package baekjoon.bronze.b5

fun main() {
    val arr = Array(readln().toInt()) { it + 1 }
    println(arr.sum())
    println(arr.sum() * arr.sum())
    println(arr.sumOf { it * it * it })
}