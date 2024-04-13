package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val room = Array(2) { Array(6) { 0 } }
    repeat(n) {
        val (gender, grade) = readLine().split(" ").map { it.toInt() }
        room[gender][grade - 1]++
    }
    println(room.sumOf { it.sumOf { it / k + if (it % k == 0) 0 else 1 } })
}