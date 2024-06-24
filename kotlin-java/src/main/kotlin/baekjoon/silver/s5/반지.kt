package baekjoon.silver.s5

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    println((1..readLine().toInt()).fold(0) { acc, _ -> if (str in readLine().repeat(2)) acc + 1 else acc })
}