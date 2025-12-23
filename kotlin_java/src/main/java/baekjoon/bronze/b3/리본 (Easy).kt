package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val x = readln().split(" ").map { it.toLong() }
    val l = readln().split(" ").map { it.toLong() }
    val c = readln().split(" ")

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (c[i] != c[j] && abs(x[i] - x[j]) <= l[i] + l[j]) {
                println("YES")
                println("${i + 1} ${j + 1}")
                return
            }
        }
    }

    println("NO")
}