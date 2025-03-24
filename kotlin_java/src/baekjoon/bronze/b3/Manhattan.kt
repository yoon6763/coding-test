package baekjoon.bronze.b3

import kotlin.math.absoluteValue

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    println(List(readln().toInt()) { readln().split(" ").map { it.toInt() } }.sortedBy {
        (it[0] - arr[0]).absoluteValue + (it[1] - arr[1]).absoluteValue
    }[0].joinToString(" "))
}