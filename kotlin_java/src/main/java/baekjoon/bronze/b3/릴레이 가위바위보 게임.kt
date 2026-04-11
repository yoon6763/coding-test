package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val c = IntArray(4)
    readln().split(" ").forEach { c[it.toInt()]++ }
    for (i in 1..3) {
        if (c[i] < n) println(i)
    }

    for (i in 1..3) {
        if (c[i] > n) println(i)
    }
}