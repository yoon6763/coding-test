package baekjoon.gold.g3.개미굴

import java.lang.StringBuilder
import java.util.StringTokenizer

data class Node(val name: String, val child: ArrayList<Node> = ArrayList())

var n = -1
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    val root = Node("")


    repeat(n) {
        // 루트 노드에서
        val st = StringTokenizer(readLine())

        var node = root

        repeat(st.nextToken().toInt()) {
            val name = st.nextToken()
            var idx = -1

            for (i in 0 until node.child.size) {
                if (node.child[i].name == name) {
                    idx = i
                    break
                }
            }

            node = if (idx == -1) {
                node.child.add(Node(name))
                node.child.last()
            } else {
                node.child[idx]
            }
        }
    }

    print(root, -1)
    print(sb)
}

fun print(node: Node, depth: Int) {
    node.child.sortBy { it.name }
    if (depth != -1) {
        repeat(depth) {
            sb.append("--")
        }
        sb.append(node.name).append("\n")
    }

    node.child.forEach {
        print(it, depth + 1)
    }
}