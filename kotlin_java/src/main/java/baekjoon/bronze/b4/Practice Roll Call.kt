package baekjoon.bronze.b4

fun main() {
    for (i in 1..readln().toInt()) {
        val (a, b) = List(2) { readln() }
        println("Case $i: $b, $a")
    }
}