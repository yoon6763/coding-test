package baekjoon.bronze.b3

import kotlin.math.pow

fun main() = repeat(readln().toInt()) {
    val arr = readln().split(" ").map { it.toDouble() }.toDoubleArray()
    println(
        ((9.23076) * (26.7 - arr[0]).pow(1.835)).toInt() +
                ((1.84523) * (arr[1] - 75).pow(1.348)).toInt() +
                ((56.0211) * (arr[2] - 1.5).pow(1.05)).toInt() +
                ((4.99087) * (42.5 - arr[3]).pow(1.81)).toInt() +
                ((0.188807) * (arr[4] - 210).pow(1.41)).toInt() +
                ((15.9803) * (arr[5] - 3.8).pow(1.04)).toInt() +
                ((0.11193) * (254 - arr[6]).pow(1.88)).toInt()
    )
}