package baekjoon.bronze.b1

import java.util.ArrayDeque

fun main() {
    val q = ArrayDeque<Int>()
    val (n, k) = readln().split(" ").map { it.toInt() }
    readln().split(",").map { it.toInt() }.forEach { q.add(it) }
    repeat(k) {
        repeat(q.size - 1) {
            q.add(q.first - q.removeFirst())
        }
        q.removeFirst()
    }
    println(q.joinToString(","))
}