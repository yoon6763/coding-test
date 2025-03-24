package baekjoon.bronze.b3

fun main() {
    readln()
    var (front, back) = 0 to 0
    readln().split(" ").map { it.toInt() }.forEach {
        if (it == 0) front++
        else back++
    }
    println(minOf(front, back))
}