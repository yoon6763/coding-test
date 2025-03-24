package baekjoon.bronze.b3

fun main() {
    readln()
    val line = readln()
    val a = line.count { it == 'A' }
    val b = line.count { it == 'B' }
    println(if (a > b) 'A' else if (a < b) 'B' else "Tie")
}