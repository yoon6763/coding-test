package baekjoon.bronze.b4

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val aa = a * 7
    val bb = b * 13
    when {
        aa > bb -> println("Axel")
        aa < bb -> println("Petra")
        else -> println("lika")
    }
}