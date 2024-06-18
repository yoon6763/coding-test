package baekjoon.gold.g5.`흙길 보수하기`

class Node(var start: Int, var end: Int) {
    constructor(list: List<Int>) : this(list[0], list[1])
}

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    var ans = 0
    var cur = 0

    List(n) { Node(readLine().split(" ").map { it.toInt() }) }
        .sortedBy { it.start }
        .forEach { next ->
            if (cur >= next.end) return@forEach
            if (next.start < cur) next.start = cur

            val needBoard = (next.end - next.start) / m + if ((next.end - next.start) % m == 0) 0 else 1
            ans += needBoard
            cur = next.start + needBoard * m
        }

    println(ans)
}