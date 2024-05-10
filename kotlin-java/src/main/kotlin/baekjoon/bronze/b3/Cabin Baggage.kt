package baekjoon.bronze.b3

fun main() = print(List(readln().toInt()) {
    val (height, vertical, horizon, weight) = readln().replace("  "," ").trim().split(" ").map { it.toDouble() }
    val ans = if ((height <= 56.0 && vertical <= 45.0 && horizon <= 25.0 || height + vertical + horizon <= 125.0) && weight <= 7.0) 1 else 0
    println(ans)
    ans
}.sum())