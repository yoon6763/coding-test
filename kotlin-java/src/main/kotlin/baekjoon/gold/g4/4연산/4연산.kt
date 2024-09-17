package baekjoon.gold.g4.`4연산`

import kotlin.system.exitProcess

data class Node(val num: Long, val op: String)

fun main() {
    val (start, end) = readln().split(" ").map { it.toLong() }.apply {
        if (this[0] == this[1]) {
            println(0)
            exitProcess(0)
        }
    }

    val visited = hashSetOf(start)
    val q = ArrayDeque<Node>().apply { add(Node(start, "")) }
    val oper = arrayOf(
        '*' to { it: Long -> it * it },
        '+' to { it: Long -> it + it },
        '-' to { it: Long -> it - it },
        '/' to { it: Long -> it / it }
    )

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()

        for (i in 0..<4) {
            val next = oper[i].second(cur.num)
            val newOp = cur.op + oper[i].first

            if (next == end) {
                println(newOp)
                return
            }

            if (next < 1 || next in visited) continue
            visited.add(next)
            q.add(Node(next, newOp))
        }
    }

    println(-1)
}