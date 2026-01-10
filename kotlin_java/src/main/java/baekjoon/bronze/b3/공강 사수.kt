package baekjoon.bronze.b3

fun main() {
    println(if (List(readln().toInt()) { readln() }.toSet().size == 5) "NO" else "YES")
}