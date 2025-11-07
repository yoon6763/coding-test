package baekjoon.bronze.b4

fun main() {
    val n = readln().toInt()
    val w = readln().toInt()
    var score = n * 10
    if (n >= 3) score += 20
    if (n == 5) score += 50
    if (w > 1000) score -= 15
    println(maxOf(0, score))
}
