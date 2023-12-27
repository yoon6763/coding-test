package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    val nums = readln().split(" ").map { it.toInt() }
    val price = arrayOf(350.34, 230.90, 190.55, 125.30, 180.90)
    println("\$%.2f".format(nums.zip(price).sumOf { it.first * it.second }))
}