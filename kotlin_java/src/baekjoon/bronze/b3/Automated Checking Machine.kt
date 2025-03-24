package baekjoon.bronze.b3

fun main() {
    val x = readln().split(" ").map { it.toInt() }.toMutableList()
    val y = readln().split(" ").map { it.toInt() }
    for (i in 0..<5) x[i] += y[i]
    println(if (x.count { it == 1 } == 5) "Y" else "N")
}
