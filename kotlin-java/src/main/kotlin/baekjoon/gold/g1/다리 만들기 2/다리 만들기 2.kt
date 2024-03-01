package baekjoon.gold.g1.`다리 만들기 2`

import java.util.PriorityQueue
import java.util.StringTokenizer


data class Point(val x: Int, val y: Int)

data class Edge(val from: Int, val to: Int, val weight: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.weight - other.weight
    }
}

lateinit var map: Array<Array<Int>>
lateinit var parent: Array<Int>
var islandIndex = 0
var n = 0
var m = 0
val islandList = ArrayList<Point>()
val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    // 바다 0, 섬 -1로 초기화
    map = Array(n) {
        st = StringTokenizer(readLine())
        Array(m) { if (st.nextToken().toInt() == 0) 0 else -1 }
    }

    // 섬을 그룹화함
    repeat(n) { x ->
        repeat(m) { y ->
            if (map[x][y] == -1) {
                islandIndex++
                groupingIsland(x, y)
            }
        }
    }

    parent = Array(islandIndex + 1) { it }

    val pq = PriorityQueue<Edge>()

    // 섬에서 다른 섬으로 가는 모든 다리를 탐색
    islandList.forEach { point ->
        for (i in 0 until 4) {
            var bridgeLength = 1

            while (true) {
                val nx = point.x + dx[i] * bridgeLength
                val ny = point.y + dy[i] * bridgeLength

                // 이동헀는데 현재 섬임 -> 다음 케이스로
                if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == map[point.x][point.y]) break

                // 현재 섬이 아니면서, 바다가 아님 => 다른 섬을 만남
                if (map[nx][ny] != 0) {
                    if (bridgeLength >= 3) {
                        pq.offer(Edge(map[point.x][point.y], map[nx][ny], bridgeLength - 1)) // 시작 섬, 도착 섬, 다리 길이
                    }
                    break
                }

                bridgeLength++
            }
        }
    }

    var total = 0
    var bridgeCnt = 0

    while (pq.isNotEmpty()) {
        val target = pq.poll()
        if (union(target.from, target.to)) {
            total += target.weight
            bridgeCnt++
        }
    }

    println(if (bridgeCnt == islandIndex - 1) total else -1)
}

fun groupingIsland(x: Int, y: Int) {
    map[x][y] = islandIndex
    islandList.add(Point(x, y))

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] != -1) continue
        groupingIsland(nx, ny)
    }
}

fun find(x: Int): Int {
    return if (x == parent[x]) x
    else {
        parent[x] = find(parent[x])
        parent[x]
    }
}

fun union(x: Int, y: Int): Boolean {
    val nx = find(x)
    val ny = find(y)
    return if (nx != ny) {
        parent[nx] = ny
        true
    } else false
}