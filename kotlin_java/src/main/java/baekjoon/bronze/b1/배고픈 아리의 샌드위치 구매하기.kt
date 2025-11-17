package baekjoon.bronze.b1

fun main() {
    var (s, m) = readln().split(" ").map { it.toInt() }

    if (s < 1024) {
        println("No thanks")
    } else {
        s -= 1023
        println(if (s and m == s) "Thanks" else "Impossible")
    }
}
