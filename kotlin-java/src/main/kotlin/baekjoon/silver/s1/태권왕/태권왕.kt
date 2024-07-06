package baekjoon.silver.s1.`태권왕`

class Node(val x: Int, val y: Int, val depth: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val (me, you) = readLine().split(" ").map { it.toInt() }

        val q = ArrayDeque<Node>()
        q.add(Node(me, you, 0))

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()

            if (cur.x == cur.y) {
                sb.appendLine(cur.depth)
                break
            }

            if (cur.x > cur.y) continue
            q.add(Node(cur.x * 2, cur.y + 3, cur.depth + 1))
            q.add(Node(cur.x + 1, cur.y, cur.depth + 1))
        }
    }

    print(sb)
}