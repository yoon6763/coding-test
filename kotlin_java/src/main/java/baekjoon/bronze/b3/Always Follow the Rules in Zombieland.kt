package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = List(n) { readln() }
    repeat(readln().toInt()) {
        val m = readln().toInt()
        if (m in 1..n) println("Rule $m: ${arr[m - 1]}")
        else println("Rule $m: No such rule")
    }
}
