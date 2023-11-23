package baekjoon.gold.g2

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {

    val INF = 987654321
    val n = readLine().toInt()
    val m = readLine().toInt()

    val connect = Array(n + 1) { Array(n + 1) { INF } }
    repeat(n) {
        connect[it + 1][it + 1] = 0
    }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val (a, b) = Array(2) { st.nextToken().toInt() }
        connect[a][b] = 1
        connect[b][a] = 1
    }


    // 플로아드 - 와샬 적용
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (connect[i][j] > connect[i][k] + connect[k][j]) {
                    connect[i][j] = connect[i][k] + connect[k][j]
                }
            }
        }
    }

    val visited = BooleanArray(n + 1)
    val president = ArrayList<Int>()

    for (i in 1..n) {
        if (visited[i]) continue

        val party = ArrayList<Int>()

        for (j in 1..n) {
            // i와 j로 가는 경로가 있다면 (!= INF) i는 j 와 같은 위원회!!!
            if (connect[i][j] != INF) {
                party.add(j)
                visited[j] = true
            }
        }

        var min = INF
        var minIdx = 0

        party.forEach { p ->
            var max = 0
            for (j in 1..n) {
                // i와 j로 가는 경로가 있다면 (!= INF) i는 j 와 같은 위원회,
                // 그 중에서 가장 멀리 있는 사람을 찾음
                if (connect[p][j] != INF && connect[p][j] > max) {
                    max = connect[p][j]
                }
            }

            // 가장 멀리 있는 사람 쌍 중에서 길이가 가장 짧은 쌍을 찾음
            if (max < min) {
                min = max
                minIdx = p
            }
        }

        president.add(minIdx)
    }

    val sb = StringBuilder()
    sb.append(president.size).append("\n")
    president.sorted().forEach {
        sb.append("$it\n")
    }

    print(sb)
}
