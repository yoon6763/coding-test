package baekjoon.platinum.p5.`벌집`

data class Node(var x: Int, var y: Int)

const val MAP_SIZE = 1200

fun main() {
    val (startPoint, endPoint) = readln().split(" ").map { it.toInt() }
    if (startPoint == endPoint) {
        println(startPoint)
        return
    }

    val map = generateHoneycombMap()

    var startNode = Node(-1, -1)
    var endNode = Node(-1, -1)

    for (i in 0 until MAP_SIZE) {
        for (j in 0 until MAP_SIZE) {
            if (map[i][j] == startPoint) {
                startNode = Node(i, j)
            }
            if (map[i][j] == endPoint) {
                endNode = Node(i, j)
            }
        }
    }

    val prePath = bfsAndGeneratePrePath(map, startNode, endNode)
    val path = findPath(map, endNode, prePath)

    println(path.joinToString(" "))
}

fun findPath(map: Array<IntArray>, endNode: Node, prePath: Array<Array<Node?>>): ArrayDeque<Int> {
    val path = ArrayDeque<Int>()
    var preNode = endNode

    path.addFirst(map[preNode.x][preNode.y])

    while (true) {
        val nowNode = prePath[preNode.x][preNode.y] ?: break
        path.addFirst(map[nowNode.x][nowNode.y])
        preNode = nowNode
    }

    return path
}

fun bfsAndGeneratePrePath(map: Array<IntArray>, startNode: Node, endNode: Node): Array<Array<Node?>> {
    val bfsDx = intArrayOf(-1, -1, 0, 1, 1, 0)
    val bfsDy = intArrayOf(0, 1, 1, 0, -1, -1)

    val queue = ArrayDeque<Node>()
    val visited = Array(MAP_SIZE) { BooleanArray(MAP_SIZE) { false } }
    val prePath = Array(MAP_SIZE) { Array<Node?>(MAP_SIZE) { null } }

    queue.add(Node(startNode.x, startNode.y))
    visited[startNode.x][startNode.y] = true

    bfs@ while (queue.isNotEmpty()) {
        val (curX, curY) = queue.removeFirst()

        for (i in 0 until 6) {
            val nx = curX + bfsDx[i]
            val ny = curY + bfsDy[i]

            if (visited[nx][ny] || map[nx][ny] == 0) continue
            visited[nx][ny] = true
            queue.add(Node(nx, ny))
            prePath[nx][ny] = Node(curX, curY)

            if (nx == endNode.x && ny == endNode.y) {
                break@bfs
            }
        }
    }

    return prePath
}


fun generateHoneycombMap(): Array<IntArray> {
    val map = Array(MAP_SIZE) { IntArray(MAP_SIZE) { 0 } }

    map[MAP_SIZE / 2][MAP_SIZE / 2] = 1

    var num = 2
    var x = MAP_SIZE / 2
    var y = MAP_SIZE / 2 - 1

    var dir = 0
    var layer = 1

    val mapGeneratorDx = intArrayOf(-1, 0, 1, 1, 0, -1)
    val mapGeneratorDy = intArrayOf(1, 1, 0, -1, -1, 0)

    while (num <= 1000000) {
        for (i in 0..<layer) {
            x += mapGeneratorDx[dir]
            y += mapGeneratorDy[dir]
            map[x][y] = num++
        }
        dir++
        if (dir == 6) {
            dir = 0
            layer++
            y--
        }
    }

    return map
}