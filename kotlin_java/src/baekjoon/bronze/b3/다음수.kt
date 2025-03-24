package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toLong() }
        if(a == 0L && b == 0L && c == 0L) break
        if (a - b == b - c) println("AP ${c + b - a}")
        else println("GP ${c * (b / a)}")
    }
}