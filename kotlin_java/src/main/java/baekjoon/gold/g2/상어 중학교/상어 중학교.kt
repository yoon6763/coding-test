package baekjoon.gold.g2.`상어 중학교`

import java.util.*

data class Node(val x: Int, val y: Int)
data class Group(var rainbowBlockCnt: Int, var standardX: Int, var standardY: Int, var groupSize: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var ans = 0
    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
    val visited = Array(n) { BooleanArray(n) }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    while (true) {
        visited.forEach { it.fill(false) }
        val groupList = mutableListOf<Group>()

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (map[i][j] <= 0 || visited[i][j]) continue

                val initialColor = map[i][j]

                val q = LinkedList<Node>() as Queue<Node>
                q.add(Node(i, j))
                visited[i][j] = true
                val group = Group(0, i, j, 1)

                val rainbowBlocks = mutableListOf<Node>()

                while (q.isNotEmpty()) {
                    val cur = q.poll()

                    for (k in 0 until 4) {
                        val nx = cur.x + dx[k]
                        val ny = cur.y + dy[k]

                        if (nx !in 0 until n ||
                            ny !in 0 until n ||
                            map[nx][ny] == -1 ||
                            map[nx][ny] == -2 ||
                            map[nx][ny] != 0 && map[nx][ny] != initialColor ||
                            visited[nx][ny]
                        ) continue

                        if (map[nx][ny] == 0) {
                            rainbowBlocks.add(Node(nx, ny))
                            group.rainbowBlockCnt++
                        } else {
                            if (nx < group.standardX) {
                                group.standardX = nx
                                group.standardY = ny
                            } else if (nx == group.standardX && ny < group.standardY) {
                                group.standardY = ny
                            }
                        }

                        q.offer(Node(nx, ny))
                        visited[nx][ny] = true
                        group.groupSize++
                    }
                }

                if (group.groupSize >= 2) {
                    groupList.add(group)
                }

                rainbowBlocks.forEach { visited[it.x][it.y] = false }
            }
        }
        if (groupList.isEmpty()) break

        /*
            1. 그룹의 크기가 가장 큰 순
            2. 무지개 블록의 수가 가장 많은 순
            3. 행이 가장 큰 순
            4. 열이 가장 큰 순
         */
        groupList.sortWith(compareBy({ -it.groupSize }, { -it.rainbowBlockCnt }, { -it.standardX }, { -it.standardY }))

        val selectedGroup = groupList.first()
        val q = LinkedList<Node>() as Queue<Node>
        q.add(Node(selectedGroup.standardX, selectedGroup.standardY))

        val initialColor = map[selectedGroup.standardX][selectedGroup.standardY]
        map[selectedGroup.standardX][selectedGroup.standardY] = -2
        var blockCnt = 1

        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (i in 0 until 4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (nx !in 0 until n ||
                    ny !in 0 until n ||
                    map[nx][ny] != 0 && map[nx][ny] != initialColor
                ) continue

                blockCnt++
                map[nx][ny] = -2
                q.offer(Node(nx, ny))
            }
        }

        ans += blockCnt * blockCnt

        gravity(map)


        // 블록 반시계 방향으로 90도 회전
        val rotatedMap = Array(n) { Array(n) { -2 } }
        for (i in 0 until n) {
            for (j in 0 until n) {
                rotatedMap[n - 1 - j][i] = map[i][j]
            }
        }

        // 블록 내리기
        gravity(rotatedMap)

        for (i in 0 until n) {
            for (j in 0 until n) {
                map[i][j] = rotatedMap[i][j]
            }
        }
    }

    println(ans)
}

fun gravity(map: Array<Array<Int>>) {
    val n = map.size

    for (i in n - 2 downTo 0) {
        for (j in 0 until n) {
            if (map[i][j] == -1) continue

            var nx = i
            while (nx + 1 < n && map[nx + 1][j] == -2) {
                map[nx + 1][j] = map[nx][j]
                map[nx][j] = -2
                nx++
            }
        }
    }
}