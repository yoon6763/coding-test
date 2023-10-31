package baekjoon.platinum.p4.문명

import java.util.LinkedList
import java.util.Queue

lateinit var parent: IntArray

data class Node(val x: Int, val y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, civilCount) = readLine().split(" ").map { it.toInt() }
    parent = IntArray(civilCount + 1) { it }

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)

    val map = Array(n) { IntArray(n) { 0 } }
    val q = LinkedList<Node>() as Queue<Node>

    repeat(civilCount) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
        q.offer(Node(x, y))
        map[x][y] = it + 1
    }

    var unionCivils = 1
    var year = 0

    // 초기 인접 국가 합치기
    q.forEach { (x, y) ->
        for(j in 0 until 4) {
            val nx = x + dx[j]
            val ny = y + dy[j]

            if(nx !in 0 until n || ny !in 0 until n || map[nx][ny] == 0) continue
            if(map[nx][ny] != map[x][y]) {
                if(union(map[x][y], map[nx][ny])) {
                    unionCivils++
                }
            }
        }
    }

    if(unionCivils == civilCount) {
        println(0)
        return
    }

    while (q.isNotEmpty()) {
        repeat(q.size) {
            val cur = q.poll()

            for (i in 0 until 4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]
                if (nx !in 0 until n || ny !in 0 until n) continue

                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[cur.x][cur.y]
                    q.offer(Node(nx, ny))
                } else if (map[nx][ny] != map[cur.x][cur.y]) {
                    if (union(map[cur.x][cur.y], map[nx][ny])) {
                        unionCivils++
                    }
                }

                // 인접 국가 합치기
                for (j in 0 until 4) {
                    val nnx = nx + dx[i]
                    val nny = ny + dy[i]

                    if (nnx !in 0 until n || nny !in 0 until n || map[nnx][nny] == 0) continue
                    if (map[nnx][nny] != map[nx][ny]) {
                        if (union(map[nx][ny], map[nnx][nny])) {
                            unionCivils++
                        }
                    }
                }
            }
        }
        year++

        if (unionCivils == civilCount) {
            println(year)
            return
        }
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
    val (px, py) = listOf(find(x), find(y))

    return if (px != py) {
        parent[py] = px
        true
    } else false
}