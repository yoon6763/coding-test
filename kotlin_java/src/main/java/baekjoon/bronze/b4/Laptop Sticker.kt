package baekjoon.bronze.b4

fun main() {
    val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
    if(x1 > x2+1 && y1 > y2+1) println(1) else println(0)
}