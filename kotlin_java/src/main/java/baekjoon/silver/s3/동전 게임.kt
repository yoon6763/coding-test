package baekjoon.silver.s3

fun main() {
    data class Node(val x: Int, val y: Int)

    val deltaLine = arrayOf(
        // 가로
        arrayOf(Node(0, 0), Node(0, 1), Node(0, 2)),
        arrayOf(Node(1, 0), Node(1, 1), Node(1, 2)),
        arrayOf(Node(2, 0), Node(2, 1), Node(2, 2)),
        // 세로
        arrayOf(Node(0, 0), Node(1, 0), Node(2, 0)),
        arrayOf(Node(0, 1), Node(1, 1), Node(2, 1)),
        arrayOf(Node(0, 2), Node(1, 2), Node(2, 2)),
        // 대각선
        arrayOf(Node(0, 0), Node(1, 1), Node(2, 2)),
        arrayOf(Node(0, 2), Node(1, 1), Node(2, 0))
    )

    fun Array<Array<Int>>.parseVisited(): Int {
        return this.joinToString("") { it.joinToString("") }.toInt(2)
    }

    fun Int.parseMap(): Array<Array<Int>> {
        val bin = this.toString(2).padStart(9, '0')
        return Array(3) { i -> Array(3) { j -> bin[i * 3 + j].digitToInt() } }
    }

    fun Array<Array<Int>>.finished(): Boolean {
        return deltaLine.all { it.all { this[it.x][it.y] == 1 } } || deltaLine.all { it.all { this[it.x][it.y] == 0 } }
    }

    next@ for (i in 0 until readln().toInt()) {
        val map = Array(3) { readln().split(" ").map { if (it == "H") 1 else 0 }.toTypedArray() }
        if (map.finished()) {
            println(0)
            continue
        }

        val visited = mutableSetOf<Int>()
        visited.add(map.parseVisited())

        var answer = 0
        val q = ArrayDeque<Int>()
        q.add(visited.first())

        while (q.isNotEmpty()) {
            answer++

            for (j in 0..<q.size) {
                val cur = q.removeFirst().parseMap()

                for (dl in deltaLine) {
                    val next = Array(3) { i -> Array(3) { j -> cur[i][j] } }
                    dl.forEach { next[it.x][it.y] = next[it.x][it.y].xor(1) }

                    if (next.finished()) {
                        println(answer)
                        continue@next
                    }

                    val nextVisited = next.parseVisited()
                    if (nextVisited in visited) continue
                    visited.add(nextVisited)
                    q.add(nextVisited)
                }
            }
        }

        println(-1)
    }
}