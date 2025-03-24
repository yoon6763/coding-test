package baekjoon.bronze.b3

fun main() {
    val (m, n) = List(2) { readln().toInt() }
    val count = (1..m).sumOf { i -> (1..n).count { j -> i + j == 10 } }
    println(if (count == 1) "There is 1 way to get the sum 10." else "There are $count ways to get the sum 10.")
}