package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val prices = IntArray(n) { readln().toInt() }
    val minP = prices.min()
    val maxP = prices.max()
    val result = maxOf(0, minP - maxP / 2)
    println(result)

}