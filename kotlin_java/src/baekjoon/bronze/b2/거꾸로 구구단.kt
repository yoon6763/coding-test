package baekjoon.bronze.b2

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    println(Array(b + 1) { (it * a).toString().reversed().toInt() }.maxOrNull()!!)
}