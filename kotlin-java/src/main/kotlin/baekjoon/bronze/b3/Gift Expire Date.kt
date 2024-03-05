package baekjoon.bronze.b3

fun main() {
    val toTime: (List<Int>) -> Int = { it[0] * 24 * 60 + it[1] * 60 + it[2] }
    val std = toTime(readln().split("-").map { it.toInt() })
    println(List(readln().toInt()) { toTime(readln().split("-").map { it.toInt() }) }.count { it >= std })
}