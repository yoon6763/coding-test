package baekjoon.bronze.b5

fun main() {
    val (a,b) = readln().split(" ").map { it.toInt() }
    println("${b-a} $b")
}