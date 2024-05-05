package baekjoon.silver.s2.`Kahe käigu ratsu`

data class Node(val x: Int, val y: Int)

fun main() {
    val start = readln()
    val startNode = Node(start[0].code - 'a'.code, start[1].digitToInt() - 1)
    val queue = ArrayDeque<Node>()
    val dx = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = arrayOf(1, 2, 2, 1, -1, -2, -2, -1)

    for (i in 0..<8) {
        val nx = startNode.x + dx[i]
        val ny = startNode.y + dy[i]
        if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue
        queue.add(Node(nx, ny))
    }

    val set = mutableSetOf<String>()

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        for(i in 0..<8) {
            val nx = node.x + dx[i]
            val ny = node.y + dy[i]
            if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue
            set.add("${(nx + 'a'.code).toChar()}${ny + 1}")
        }
    }

    print(set.joinToString("\n"))
}