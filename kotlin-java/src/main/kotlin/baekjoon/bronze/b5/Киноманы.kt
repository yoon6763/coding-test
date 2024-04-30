package baekjoon.bronze.b5

fun main() {
    val (t1, e1, f1) = readln().split(" ").map { it.toInt() }
    val (t2, e2, f2) = readln().split(" ").map { it.toInt() }

    val max = t1 * 3 + e1 * 20 + f1 * 120
    val mel = t2 * 3 + e2 * 20 + f2 * 120
    if (max > mel) {
        println("Max")
    } else if (max < mel) {
        println("Mel")
    } else {
        println("Draw")
    }
}