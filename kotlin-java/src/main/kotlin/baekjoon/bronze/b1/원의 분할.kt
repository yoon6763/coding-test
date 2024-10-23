package baekjoon.bronze.b1

fun main() {
    val (ab, bc, cd) = readln().split(" ").map { it.toDouble() }
    println("%.6f".format(ab.toDouble() * cd / bc))
}
