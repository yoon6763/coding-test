package baekjoon.bronze.b4

fun main() {
    val (b, w, p, n) = List(4) { readln().toInt() }

    when {
        w <= b -> println("Watermelon")
        p <= b -> println("Pomegranates")
        n <= b -> println("Nuts")
        else -> println("Nothing")
    }
}
