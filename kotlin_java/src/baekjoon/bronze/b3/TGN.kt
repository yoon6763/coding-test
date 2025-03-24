package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        val (r, e, c) = readln().split(" ").map { it.toInt() }

        if (e - c > r) {
            println("advertise")
        } else if (e - c == r) {
            println("does not matter")
        } else {
            println("do not advertise")
        }
    }
}