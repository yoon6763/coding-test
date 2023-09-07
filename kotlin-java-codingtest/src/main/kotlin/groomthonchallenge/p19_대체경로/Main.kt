package groomthonchallenge.p19_대체경로

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, start, end) = readLine().split(" ").map(String::toInt)

    val connect = Array(n + 1) { ArrayList<Int>() }
    val minDistanceWhenCityBlocked = IntArray(n + 1) { Int.MAX_VALUE }

    repeat(m) {
        val (a, b) = readLine().split(" ").map(String::toInt)
        connect[a].add(b)
        connect[b].add(a)
    }

    val visited = IntArray(n + 1) { 0 }

    for (blockedCity in 1..n) {
        visited.fill(0)
        visited[start] = 1

        val q = LinkedList<Int>() as Queue<Int>
        q.offer(start)

        bfs@ while (q.isNotEmpty()) {
            val currentCity = q.poll()

            for (i in 0 until connect[currentCity].size) {
                val nextCity = connect[currentCity][i]

                if (visited[nextCity] != 0 || nextCity == blockedCity) continue

                visited[nextCity] = visited[currentCity] + 1
                q.offer(nextCity)

                if(nextCity == end) {
                    minDistanceWhenCityBlocked[blockedCity] = visited[nextCity]
                    break@bfs
                }
            }
        }
    }

    val sb = StringBuilder()
    minDistanceWhenCityBlocked[start] = -1
    minDistanceWhenCityBlocked[end] = -1
    for (i in 1..n) {
        if (minDistanceWhenCityBlocked[i] == Int.MAX_VALUE) sb.append(-1).append("\n")
        else sb.append(minDistanceWhenCityBlocked[i]).append("\n")
    }
    print(sb)
}