package baekjoon.bronze.b3

import kotlin.math.abs

fun main() {
    val arr1 = readln().split(" ").map { it.toInt() }
    val arr2 = readln().split(" ").map { it.toInt() }
    val max1 = arr1.max()
    val max2 = arr2.max()
    println(arr1.sum() + arr2.sum() - max1 - max2 + abs(max1 - max2))
}
