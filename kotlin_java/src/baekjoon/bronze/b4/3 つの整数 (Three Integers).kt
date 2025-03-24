package baekjoon.bronze.b4

fun main() {
    val n = readln().split(" ").map { it.toInt() }
    println(if (n.count { it == 1 } > n.count { it == 2 }) 1 else 2)
}