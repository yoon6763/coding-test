package programmers.lv2.`무인도 여행`

import java.util.*

class Node(val x: Int, val y: Int)

class Solution {
    fun solution(maps: Array<String>): IntArray {

        val dx = intArrayOf(0, 0, 1, -1)
        val dy = intArrayOf(1, -1, 0, 0)
        val n = maps.size
        val m = maps[0].length

        val answer = ArrayList<Int>()
        val visited = Array(n) { Array(m) { false } }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (maps[i][j] == 'X' || visited[i][j]) continue

                val q = LinkedList<Node>() as Queue<Node>
                q.offer(Node(i, j))
                visited[i][j] = true

                var score = maps[i][j].digitToInt()

                while (q.isNotEmpty()) {
                    val cur = q.poll()

                    for (k in 0 until 4) {
                        val nx = cur.x + dx[k]
                        val ny = cur.y + dy[k]

                        if (nx !in 0 until n || ny !in 0 until m || visited[nx][ny] || maps[nx][ny] == 'X') continue
                        visited[nx][ny] = true
                        score += maps[nx][ny].digitToInt()
                        q.offer(Node(nx, ny))
                    }
                }

                answer.add(score)
            }
        }

        return if (answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }
}