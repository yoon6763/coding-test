package programmers.lv3

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    var solution = Solution()
    println(solution.solution(8, 2, arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z")))
    println(solution.solution(8, 2, arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C")))
}

class Solution {

    data class Node(var pre: Node?, var next: Node?, var isRemoved: Boolean)

    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        val records = Array(n) { Node(null, null, false) }

        for (i in 0 until n) {
            if (i != 0) records[i].pre = records[i - 1]
            if (i != n - 1) records[i].next = records[i + 1]
        }

        val stack = ArrayDeque<Node>()
        var cur = records[k]

        cmd.forEach {
            val st = StringTokenizer(it)
            when (st.nextToken()) {
                "U" -> repeat(st.nextToken().toInt()) {
                    cur = cur.pre!!
                }

                "D" -> repeat(st.nextToken().toInt()) {
                    cur = cur.next!!
                }

                "C" -> {
                    cur.isRemoved = true
                    stack.add(cur)

                    val preNode = cur.pre
                    val nextNode = cur.next

                    preNode?.next = nextNode
                    nextNode?.pre = preNode

                    cur = nextNode ?: preNode!!
                }

                "Z" -> {
                    val removedNode = stack.removeLast()
                    removedNode.isRemoved = false

                    val preNodeOfRemovedNode = removedNode.pre
                    val nextNodeOfRemovedNode = removedNode.next

                    preNodeOfRemovedNode?.next = removedNode
                    nextNodeOfRemovedNode?.pre = removedNode
                }
            }
        }

        return records.joinToString("") { if (it.isRemoved) "X" else "O" }
    }
}