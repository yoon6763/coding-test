package baekjoon.gold.g2

data class Node(var x: Int, var y: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, p) = readLine().split(" ").map { it.toInt() }
    val castleCnt = Array(p + 1) { 0 }
    val distance = Array(p + 1) { 0 }

    val qList = Array(p + 1) { ArrayDeque<Node>() }

    readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i -> distance[index + 1] = i }

    val map = Array(n) { Array(m) { 0 } }

    for (i in 0 until n) {
        val input = readLine()
        for (j in 0 until m) {
            if (input[j] == '.') map[i][j] = 0
            else if (input[j] == '#') map[i][j] = -1
            else {
                map[i][j] = input[j].digitToInt()
                castleCnt[map[i][j]]++
                qList[map[i][j]].add(Node(i, j))
            }
        }
    }

    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    var endCnt = 0
    val isEnd = Array(p + 1) { false }

    while (true) {
        if (endCnt == p) break

        for (playerNumber in 1..p) {
            if (qList[playerNumber].isEmpty()) {
                if (!isEnd[playerNumber]) {
                    isEnd[playerNumber] = true
                    endCnt++
                }
                continue
            }

            for (i in 0 until distance[playerNumber]) {
                if (qList[playerNumber].isEmpty()) break

                for(j in 0 until qList[playerNumber].size) {
                    val cur = qList[playerNumber].removeFirst()

                    for (k in 0 until 4) {
                        val nx = cur.x + dx[k]
                        val ny = cur.y + dy[k]

                        if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] != 0) continue
                        map[nx][ny] = playerNumber
                        castleCnt[playerNumber]++
                        qList[playerNumber].add(Node(nx, ny))
                    }
                }
            }
        }
    }

    println(castleCnt.slice(1..p).joinToString(" "))
}