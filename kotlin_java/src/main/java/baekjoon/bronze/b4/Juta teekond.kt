package baekjoon.bronze.b4

fun main() {
    val (a, b, c) = List(3) { readln().toInt() }

    if (a in listOf(1, 3) && b in listOf(6, 8) && c in listOf(2, 5)) {
        println("JAH")
    } else {
        println("EI")
    }
}
