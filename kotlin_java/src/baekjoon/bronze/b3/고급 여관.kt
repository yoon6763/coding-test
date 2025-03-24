package baekjoon.bronze.b3

fun main() {
    var (a1, a2) = readln().split(" ").map { it.toInt() }
    var (b1, b2) = readln().split(" ").map { it.toInt() }

    while (true) {
        a2 -= b1
        b2 -= a1
        if (a2 < 1 || b2 < 1) break
    }

    if (a2 < 1 && b2 < 1) {
        println("DRAW")
    } else {
        println("PLAYER ${if (a2 > b2) 'A' else 'B'}")
    }
}