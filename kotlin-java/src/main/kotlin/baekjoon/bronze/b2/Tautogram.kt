package baekjoon.bronze.b2

fun main() {
    while (true) {
        val line = readln().apply { if (this == "*") return }
        println(if (line.split(" ").map { it[0].lowercase() }.distinct().size == 1) "Y" else "N")
    }
}