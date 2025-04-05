package baekjoon.bronze.b2

fun main() {
    val arr = IntArray(readln().toInt()) { readln().toInt() }
    val avg = arr.average().toInt()
    println(arr.filter { it > avg }.sumOf { it - avg })
}