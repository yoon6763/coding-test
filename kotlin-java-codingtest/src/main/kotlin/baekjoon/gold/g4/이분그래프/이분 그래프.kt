package baekjoon.gold.g4.이분그래프

import java.util.*

enum class COLOR {
    NOT_VISITED,
    RED,
    BLUE
}

var v = 0
lateinit var visited: Array<COLOR>
lateinit var connectedNodes: Array<ArrayList<Int>>

fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()

    // 테스트 케이스만큼 진행
    repeat(readLine().toInt()) {

        // 정점의 수, 간선의 수
        val st = StringTokenizer(readLine())
        v = st.nextToken().toInt()
        val e = st.nextToken().toInt()

        visited = Array(v + 1) { COLOR.NOT_VISITED }
        connectedNodes = Array(v + 1) { ArrayList() }

        repeat(e) {
            val st = StringTokenizer(readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()

            connectedNodes[x].add(y)
            connectedNodes[y].add(x)
        }

        for (i in 1..v) {
            if (visited[i] == COLOR.NOT_VISITED) {
                dfs(i)
            }
        }

        // 이분 그래프인지 확인
        // 모든 정점이 이웃한 정점과 색이 다른지 (이웃 정점과 다르면 이분그래프)
        var isAble = true

        for (i in 1..v) {
            for (j in connectedNodes[i]) {
                if (visited[i] == visited[j]) {
                    isAble = false
                    break
                }
            }
            if (!isAble) break
        }

        sb.append(if (isAble) "YES\n" else "NO\n")
    }

    print(sb)
}

fun dfs(start: Int) {
    if (visited[start] == COLOR.NOT_VISITED) visited[start] = COLOR.RED

    for (i in connectedNodes[start]) {
        if (visited[i] == COLOR.NOT_VISITED) {
            visited[i] = if (visited[start] == COLOR.RED) COLOR.BLUE else COLOR.RED
            dfs(i)
        }
    }
}