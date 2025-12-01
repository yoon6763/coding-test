package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        println(List(readln().toInt()) { readln().split(" ").map { it.toInt() } }
            .sortedWith(compareBy({ -it[0].toDouble() / it[1] }, { it[1] }))[0][1])
    }
}