package baekjoon.gold.g2.벽부수고이동하기4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.LinkedList
import java.util.Queue

var n = 0
var m = 0
lateinit var map: Array<Array<Int>>
lateinit var groupMap: Array<Array<Int>>
var groupIdx = 1
val groupSizeList = ArrayList<Int>()

data class Node(var x: Int, var y: Int)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

val wallArray = ArrayList<Node>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    groupSizeList.add(0)

    val nm = br.readLine().split(" ")
    n = nm[0].toInt()
    m = nm[1].toInt()

    map = Array(n) { Array(m) { 0 } }
    groupMap = Array(n) { Array(m) { 0 } }

    repeat(n) { x ->
        val line = br.readLine()
        repeat(m) { y ->
            map[x][y] = line[y].digitToInt()
            if (map[x][y] == 1) wallArray.add(Node(x, y))
        }
    }

    val groupVisited = Array(n) { Array(m) { false } }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 0 && !groupVisited[i][j]) {
                var groupSize = 1

                val q: Queue<Node> = LinkedList()
                q.offer(Node(i,j))

                groupVisited[i][j] = true

                groupMap[i][j] = groupIdx

                while (q.isNotEmpty()) {
                    val target = q.poll()

                    for (k in 0 until 4) {
                        val dx = target.x + dx[k]
                        val dy = target.y + dy[k]

                        if (dx !in 0 until n || dy !in 0 until m || map[dx][dy] == 1 || groupVisited[dx][dy]) continue

                        groupMap[dx][dy] = groupIdx
                        q.offer(Node(dx, dy))
                        groupVisited[dx][dy] = true
                        groupSize++
                    }
                }

                groupIdx++
                groupSizeList.add(groupSize)
            }
        }
    }

    for (i in 0 until wallArray.size) {
        val startNode = wallArray[i]

        var size = 0
        val groupIds = ArrayList<Int>()

        for (j in 0 until 4) {
            val dx = dx[j] + startNode.x
            val dy = dy[j] + startNode.y


            if(dx in 0 until n && dy in 0 until m && groupMap[dx][dy] != 0) {
                val groupIdx = groupMap[dx][dy]

                if(groupIds.indexOf(groupIdx) == -1) {
                    groupIds.add(groupIdx)
                }

            }

        }
        groupIds.forEach {
            size += groupSizeList[it]
        }

        map[startNode.x][startNode.y] = size + 1
    }

    val sb = StringBuilder()
    map.forEach {
        it.forEach { sb.append(it%10) }
        sb.append("\n")
    }

    print(sb.toString())
}