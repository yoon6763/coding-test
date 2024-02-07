package baekjoon.bronze.b4

fun main() {
    val score1 = readln().toInt() * 3 + readln().toInt() * 2 + readln().toInt()
    val score2 = readln().toInt() * 3 + readln().toInt() * 2 + readln().toInt()
    when {
        score1 > score2 -> println("A")
        score1 < score2 -> println("B")
        else -> println("T")
    }
}