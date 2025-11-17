package baekjoon.bronze.b3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { ArrayList<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() - 1 }
        arr[a].add(b)
        arr[b].add(a)
    }
    println(arr.map { it.size }.joinToString("\n"))
}