package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(m) { 0 }
    repeat(n) { readln().split(" ").map { it.toInt() }.forEachIndexed { index, i -> arr[index] += i } }
    println(arr.mapIndexed { index, i -> index to i }.sortedWith(compareBy({ -it.second }, { it.first })).map { it.first + 1 }.joinToString(" "))
}