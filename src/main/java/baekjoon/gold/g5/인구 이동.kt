package baekjoon.gold.g5

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

data class Node(val x: Int, val y: Int)

fun main() {
    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(1, -1, 0, 0)

    val nlr = readLine()!!.split(" ")
    val n = nlr[0].toInt() // n * n 칸
    val l = nlr[1].toInt()
    val r = nlr[2].toInt()

    val map = Array(n) { Array<Int>(n) { 0 } }
    val tmpMap = Array(n) { Array<Int>(n) { 0 } }

    for (i in 0 until n) {
        val temp = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
        map[i] = temp.clone()
        tmpMap[i] = temp.clone()
    }

    var cnt = 0

    while (true) {
        val visited = Array(n) { Array(n) { false } }
        var isChanged = false

        for (x in 0 until n) {
            for (y in 0 until n) {
                if (visited[x][y]) continue

                val visitedNode: Queue<Node> = LinkedList()
                val q: Queue<Node> = LinkedList()
                q.offer(Node(x, y))
                visited[x][y] = true

                visitedNode.offer(Node(x, y))

                while (q.isNotEmpty()) {
                    val target = q.poll()

                    for (i in 0 until 4) {
                        val nx = target.x + dx[i]
                        val ny = target.y + dy[i]
                        if (nx in 0 until n &&
                            ny in 0 until n &&
                            abs(map[target.x][target.y] - map[nx][ny]) in l..r &&
                            !visited[nx][ny]) {

                            q.offer(Node(nx, ny))
                            visitedNode.offer(Node(nx, ny))
                            visited[nx][ny] = true
                        }
                    }
                }

                val firstNode = map[visitedNode.peek().x][visitedNode.peek().y]

                if (visitedNode.size > 1 &&
                    visitedNode.count { map[it.x][it.y] == firstNode } != visitedNode.size
                ) {
                    isChanged = true
                } else {
                    continue
                }

                var populSum = visitedNode.sumOf { map[it.x][it.y] }
                var populPerSpace = populSum / visitedNode.size
                for (node in visitedNode) {
                    tmpMap[node.x][node.y] = populPerSpace
                }
            }
        }

        for(i in 0 until n) {
            map[i] = tmpMap[i].clone()
        }

        if (!isChanged) {
            println(cnt)
            return
        }

        cnt++
    }
}

/*  3
4 10 50
10 100 20 90
80 100 60 70
70 20 30 40
50 20 100 10
 */


/* 2
3 5 10
10 15 20
20 30 25
40 22 10
 */


/* 0
2 40 50
50 30
20 40
 */


/* 1
2 20 50
50 30
30 40
 */