package baekjoon.bronze.b4


fun main() {
    val (sum, sub) = readln().split(" ").map(String::toInt)
    val score1 = (sum + sub) / 2
    val score2 = (sum - sub) / 2

    if (sum < sub) println("-1")
    else if (score1 + score2 == sum && score1 - score2 == sub) println("$score1 $score2") else println("-1")
}