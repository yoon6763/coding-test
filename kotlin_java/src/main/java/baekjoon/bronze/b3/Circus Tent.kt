package baekjoon.bronze.b3

fun main() {
    val (d, h) = readln().split(" ").map { it.toDouble() }
    val r = d / 2.0 + 5.0
    println("%.15f".format(Math.PI * r * (2.0 * h + r)))
}
