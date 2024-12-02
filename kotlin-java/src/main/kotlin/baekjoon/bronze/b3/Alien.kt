package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val (b1, b2) = readln().split(" ").map { it.toInt() }

    repeat(n) {
        val (a, b, c, d) = readln().split(" ").map { it.toInt() }
        if (a <= b1 && c >= b1 && b <= b2 && d >= b2) {
            println("Yes")
            return
        }
    }

    println("No")
}
