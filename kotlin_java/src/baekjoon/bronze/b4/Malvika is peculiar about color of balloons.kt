package baekjoon.bronze.b4

fun main() = repeat(readln().toInt()) {
    val s = readln()
    val countA = s.count { it == 'a' }
    val countB = s.length - countA
    println(minOf(countA, countB))
}
