package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0) break
        println("${a/b} ${a%b} / $b")
    }
}