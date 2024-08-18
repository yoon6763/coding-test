package baekjoon.bronze.b3

fun main() = println((1..readln().toInt()).fold(0 to 0) { (sum, max), _ -> (sum + readln().toInt()).let { it to maxOf(max, it) } }.second + 100)