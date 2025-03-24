package baekjoon.bronze.b2

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val (a, b) = readln().split(" ").map { it.toInt() }

    for (i in 0..<r * a) {
        for (j in 0..<c * b) {
            if ((i / a + j / b) % 2 == 0) {
                print("X")
            } else {
                print(".")
            }
        }
        println("")
    }
}
