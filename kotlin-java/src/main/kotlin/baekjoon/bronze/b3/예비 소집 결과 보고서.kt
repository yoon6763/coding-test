package baekjoon.bronze.b3

fun main() = print(List(readln().toInt()) {
    val arr = readln().split(" ").map { it.toInt() }.apply { if (this.all { it == -1 }) return@List 0 }
    for (i in 1..2) if (arr[i] != -1 && (arr[i] < arr[i - 1] || arr[i - 1] == -1)) return@List 0
    1
}.sum())