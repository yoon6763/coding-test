package baekjoon.bronze.b5

fun main() {
    val (ax, ay, az) = readln().split(" ").map { it.toInt() }
    val (cx, cy, cz) = readln().split(" ").map { it.toInt() }
    println("${cx-az} ${cy/ay} ${cz-ax}")
}