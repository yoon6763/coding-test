package baekjoon.bronze.b4

fun main() {
    val T = readln().toInt()
    repeat(T) {
        val t = readln().toInt()
        if (t % 25 < 17) println("ONLINE") else println("OFFLINE")
    }
}