package baekjoon.platinum.p3.`상어의 저녁식사`

import java.util.StringTokenizer

data class Shark(val size: Long, val speed: Long, val intel: Long)

lateinit var connect: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var d: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val shark = Array(n) {
        val st = StringTokenizer(readLine())
        val (size, speed, intel) = List(3) { st.nextToken().toLong() }
        Shark(size, speed, intel)
    }

    connect = Array(n) { ArrayList() }
    visited = BooleanArray(n)
    d = IntArray(n) { -1 }

    for (i in 0..<n) {
        for (j in i + 1..<n) {
            if (shark[i].size >= shark[j].size && shark[i].speed >= shark[j].speed && shark[i].intel >= shark[j].intel) {
                connect[i].add(j)
            } else if (shark[i].size <= shark[j].size && shark[i].speed <= shark[j].speed && shark[i].intel <= shark[j].intel) {
                connect[j].add(i)
            }
        }
    }

    var count = 0
    for (i in 0..<n) {
        repeat(2) {
            visited.fill(false)
            if (dfs(i)) count++
        }
    }

    println(n - count)
}

fun dfs(cur: Int): Boolean {
    connect[cur].forEach { next ->
        if (visited[next]) return@forEach
        visited[next] = true

        if (d[next] == -1 || dfs(d[next])) {
            d[next] = cur
            return true
        }
    }

    return false
}