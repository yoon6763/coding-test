package baekjoon.silver.s1

fun main() {
    data class Node(val id: Int, val comment: String, val children: MutableList<Node> = mutableListOf())

    val nodeMap = mutableMapOf<Int, Node>()
    nodeMap[0] = Node(0, "")

    for (i in 1..readln().toInt()) {
        val parentId = readln().toInt()
        val childNode = Node(i, readln())
        nodeMap[i] = childNode
        nodeMap[parentId]?.children?.add(childNode)
    }

    fun dfs(cur: Node, depth: Int) {
        if (depth >= 0) println(".".repeat(depth) + cur.comment)
        cur.children.forEach { child ->
            dfs(child, depth + 1)
        }
    }

    dfs(nodeMap[0]!!, -1)
}