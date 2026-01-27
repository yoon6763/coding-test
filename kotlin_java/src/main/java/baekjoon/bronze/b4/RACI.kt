package baekjoon.bronze.b4

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    repeat(n) {
        if (readln().split(" ").count { it == "A" } != 1) {
            println("No")
            return
        }
    }

    println("Yes")
}
