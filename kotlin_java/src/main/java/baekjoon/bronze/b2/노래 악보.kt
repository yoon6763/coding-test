package baekjoon.bronze.b2

fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val list = ((1..n).flatMap { i -> List(readln().toInt()) { i } })
    repeat(q) {
        println(list[readln().toInt()])
    }
}
