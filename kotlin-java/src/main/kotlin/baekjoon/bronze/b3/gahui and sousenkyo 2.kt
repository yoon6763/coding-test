package baekjoon.bronze.b3

fun main() {
    readln()
    val me = readln().toInt()
    println(readln().split(" ").map { it.toInt() }.count { it > me } + 1)
}