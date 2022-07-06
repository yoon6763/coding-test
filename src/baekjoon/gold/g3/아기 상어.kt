package baekjoon.gold.g3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)
var n = 0
var sharkSize = 2
var ateFish = 0
var time = 0
lateinit var map: Array<Array<Int>>

data class Node(var x: Int, var y: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()

    map = Array(n) { Array(n) { 0 } }

    val startNode = Node(0, 0)

    repeat(n) { x ->
        val st = StringTokenizer(br.readLine(), " ")
        repeat(n) { y ->
            map[x][y] = st.nextToken().toInt()

            if (map[x][y] == 9) {
                startNode!!.x = x
                startNode!!.y = y
            }
        }
    }

    while (true) {
        val bfsResult = bfs(startNode.x, startNode.y) ?: break
        startNode.x = bfsResult.x
        startNode.y = bfsResult.y
    }

    println(time)
}


fun bfs(x: Int, y: Int): Node? {
    val q: Queue<Node> = LinkedList()

    val visited = Array(n) { Array(n) { 0 } }
    q.offer(Node(x, y))

    var minLen = -1

    val eatQueue = ArrayList<Node>()

    var allFind = false

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            if (nx !in 0 until n || ny !in 0 until n || map[nx][ny] > sharkSize || visited[nx][ny] != 0)
                continue

            q.offer(Node(nx, ny))
            visited[nx][ny] = visited[target.x][target.y] + 1

            if (map[nx][ny] < sharkSize && map[nx][ny] != 0) {
                if (minLen == -1) {
                    minLen = visited[nx][ny]
                    eatQueue.add(Node(nx, ny))
                } else if (minLen == visited[nx][ny]) {
                    eatQueue.add(Node(nx, ny))
                } else {
                    allFind = true
                    break
                }
            }
        }
        if (allFind) break
    }

    if (eatQueue.size == 0) {
        return null
    } else {
        eatQueue.sortWith(compareBy<Node> { it.x }.thenBy { it.y })

        val target = eatQueue[0]
        map[target.x][target.y] = 0
        map[x][y] = 0
        time += visited[target.x][target.y]
        ateFish++

        if (sharkSize == ateFish) {
            ateFish = 0
            sharkSize++
        }

        return Node(target.x, target.y)
    }
}