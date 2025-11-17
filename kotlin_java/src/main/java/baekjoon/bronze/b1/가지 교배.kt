package baekjoon.bronze.b1

fun main() {
    readln().toInt()
    val type = readln().split(" ")
    val (n, m) = readln().split(" ").map { it.toInt() }

    repeat(n) {
        if (readln().split(" ").map { it.toInt() }.none { type[it - 1] == "P" }) {
            println("W")
            return
        }
    }

    println("P")
}
