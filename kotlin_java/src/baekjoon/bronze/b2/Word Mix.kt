package baekjoon.bronze.b2

fun main() {
    val (w1, w2) = readln().split(" ")
    println(
        (0..<minOf(w1.length, w2.length))
            .joinToString("") { if (it % 2 == 0) w1[it].toString() else w2[it].toString() })
}
