package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt() % 2
    val s1 = readln().toCharArray().map { it == '1' }
    val s2 = readln().toCharArray().map { it == '1' }

    if (n == 0) {
        if (s1 == s2) println("Deletion succeeded")
        else println("Deletion failed")
    } else {
        if (s1.zip(s2).all { it.first != it.second }) println("Deletion succeeded")
        else println("Deletion failed")
    }
}