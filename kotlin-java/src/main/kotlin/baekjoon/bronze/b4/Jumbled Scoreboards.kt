package baekjoon.bronze.b4

fun main() {
    val arr = List(readln().toInt()) { readln().split(" ").map { it.toInt() } }
    println(if (arr.zipWithNext().all { (a, b) -> a[0] <= b[0] && a[1] <= b[1] }) "yes" else "no")
}