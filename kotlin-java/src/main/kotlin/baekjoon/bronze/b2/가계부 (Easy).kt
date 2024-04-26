package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { 0L }
    repeat(m) {
        val (type, p, q) = readln().split(" ").map { it.toInt() }
        if (type == 1) arr[p] += q.toLong() else if (type == 2) println(arr.slice(p..q).sum())
    }
}