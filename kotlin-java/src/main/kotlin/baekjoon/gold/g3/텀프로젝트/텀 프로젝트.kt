package baekjoon.gold.g3.텀프로젝트

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var n = 0
lateinit var student: Array<Int>
lateinit var visited: Array<Boolean>
lateinit var grouped: Array<Boolean>
var groupedCnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        n = br.readLine().toInt()
        student = Array(n + 1) { 0 }
        visited = Array(n + 1) { false }
        grouped = Array(n + 1) { false }
        groupedCnt = 0

        val st = StringTokenizer(br.readLine(), " ")

        for (i in 1..n) {
            student[i] = st.nextToken().toInt()
            if (student[i] == i) {
                grouped[i] = true // 자기 자신을 가르키고 있다면 그룹화
                groupedCnt++
            }
        }

        for (i in 1..n) {
            if (!grouped[i]) dfs(i)
        }
        sb.append(n - groupedCnt).append("\n")
    }
    print(sb.toString())
}

private fun dfs(idx: Int) {
    if (visited[idx]) {
        return
    }

    visited[idx] = true

    if (!visited[student[idx]]) {
        // 방문한적 없음
        dfs(student[idx])
    } else {
        if (!grouped[student[idx]]) {
            // 방문한적 있는데 아직 그룹화가 안됬음 -> 전체 혹은 중간에 사이클 만남
            groupedCnt++
            grouped[student[idx]] = true

            // 사이클이니까 다시 처음 값(idx)으로 돌아올때 까지 계속 그룹화 해줌
            var ptr = student[idx]
            while (ptr != idx) {
                groupedCnt++
                ptr = student[ptr]
                grouped[ptr] = true
            }
        }
    }

    grouped[idx] = true
}

/*
2
7
3 1 3 7 3 4 6
8
1 2 3 4 5 6 7 8
 */