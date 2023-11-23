package baekjoon.gold.g1.복제로봇

import java.util.*
import kotlin.collections.ArrayList

data class Edge(val from: Int, val to: Int, val weight: Int)
data class Node(val x: Int, val y: Int)

lateinit var map: Array<CharArray>
lateinit var graph: Array<ArrayList<Edge>>
var n = 0

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ").map(String::toInt)
    n = nm[0]
    val m = nm[1]

    graph = Array(m + 1) { ArrayList() }

    val robotAndKeysPoints = ArrayList<Node>()
    val robotAndKeysIndexMap = HashMap<Node, Int>()

    map = Array(n) { x ->
        val line = readLine().toCharArray()
        for (y in 0 until n) {
            if (line[y] == 'K' || line[y] == 'S') {
                robotAndKeysPoints.add(Node(x, y))
                robotAndKeysIndexMap[Node(x, y)] = robotAndKeysPoints.size - 1 // 좌표에 번호 붙이기
            }
        }
        line
    }

    makeGraphUsingBFS(robotAndKeysPoints, robotAndKeysIndexMap)

    parent = IntArray(m + 1) { it }

    val pq = PriorityQueue<Edge>(compareBy { it.weight })
    for (i in 0 until m) {
        graph[i].forEach { edge ->
            pq.add(Edge(i, edge.to, edge.weight))
        }
    }

    var ans = 0
    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        if (union(cur.from, cur.to)) ans += cur.weight
    }

    val first = parent[0]
    println(if (parent.all { it == first }) ans else -1)
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val (px, py) = find(x) to find(y)
    return if (px == py) false
    else {
        parent[px] = py
        true
    }
}

fun makeGraphUsingBFS(robotAndKeysPoints: ArrayList<Node>, robotAndKeysIndexMap: HashMap<Node, Int>) {
    val visited = Array(n) { IntArray(n) { 0 } }

    robotAndKeysPoints.forEachIndexed { index, node ->
        visited.forEach { it.fill(0) }

        val q = LinkedList<Node>() as Queue<Node>
        q.add(node)
        visited[node.x][node.y] = 1

        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (i in 0 until 4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] > 0 || map[nx][ny] == '1') continue

                q.add(Node(nx, ny))
                visited[nx][ny] = visited[cur.x][cur.y] + 1

                if (map[nx][ny] == 'K' || map[nx][ny] == 'S') {
                    graph[index].add(Edge(index, robotAndKeysIndexMap[Node(nx, ny)]!!, visited[nx][ny] - 1))
                }
            }
        }
    }
}