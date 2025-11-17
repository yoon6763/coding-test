package baekjoon.bronze.b3

fun main() {
    val list = List(readln().toInt()) { readln().split(" ").map { it.toInt() } }
    val sorted = list.sortedWith(compareBy({ -it[0] }, { it[1] }, { it[2] }))
    println(list.indexOf(sorted[0]) + 1)
}
