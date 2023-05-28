package baekjoon.gold.g3.다리만들기

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Node(val x: Int, val y: Int)

val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val map = Array(n) {
        val st = StringTokenizer(readLine())
        Array(n) { st.nextToken().toInt() }
    }

    var visited = Array(n) { Array(n) { false } }
    val islands = LinkedList<Node>() as Queue<Node>

    var groupIndex = 2

    // 모든 섬을 그룹화 (BFS)
    repeat(n) { x ->
        repeat(n) { y ->
            if (!visited[x][y] && map[x][y] == 1) {
                // BFS
                visited[x][y] = true
                map[x][y] = groupIndex
                islands.add(Node(x, y))

                val q = LinkedList<Node>() as Queue<Node>
                q.offer(Node(x, y))

                while (q.isNotEmpty()) {
                    val target = q.poll()

                    for (i in 0 until 4) {
                        val nx = target.x + dx[i]
                        val ny = target.y + dy[i]

                        if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] || map[nx][ny] != 1) continue

                        q.offer(Node(nx, ny))
                        visited[nx][ny] = true
                        islands.add(Node(nx, ny))
                        map[nx][ny] = groupIndex
                    }
                }
                groupIndex++
            }
        }
    }

    var minLength = Int.MAX_VALUE

    while (islands.isNotEmpty()) {
        // 각 섬의 모든 좌표에서 BFS 수행
        val startPoint = islands.poll()
        val q = LinkedList<Node>() as Queue<Node>

        val visited = Array(n) { Array(n) { -1 } }
        visited[startPoint.x][startPoint.y] = 0

        q.offer(Node(startPoint.x, startPoint.y))

        // while 문 라벨링
        bfs@ while (q.isNotEmpty()) {
            val target = q.poll()

            for (i in 0 until 4) {
                val nx = target.x + dx[i]
                val ny = target.y + dy[i]

                if (nx !in 0 until n || ny !in 0 until n || map[nx][ny] == map[startPoint.x][startPoint.y] || visited[nx][ny] != -1) continue

                // 시작 섬과 같지 않으면서 바다가 아님 -> 새로운 섬을 만남
                if (map[nx][ny] != 0) {
                    minLength = minOf(minLength, visited[target.x][target.y])
                    break@bfs // 라벨링한 반복문을 탈출
                }

                q.offer(Node(nx, ny))
                visited[nx][ny] = visited[target.x][target.y] + 1
            }
        }
    }

    println(minLength)
}