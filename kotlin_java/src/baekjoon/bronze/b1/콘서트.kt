package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map(String::toInt).sorted()
    println((arr.indices.firstOrNull { it + 1 != arr[it] } ?: n) + 1)
}
