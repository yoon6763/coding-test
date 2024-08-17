package baekjoon.bronze.b2

import kotlin.math.abs

fun main() {
    val w = readln().split(" ").map { it.toInt() }[0]
    val visited = hashSetOf(w)
    val list = arrayListOf(0, w)

    readln().split(" ").map { it.toInt() }.forEach { cur ->
        visited.addAll(list.map { abs(cur - it) })
        list.add(cur)
    }

    println(visited.sorted().joinToString(" "))
}