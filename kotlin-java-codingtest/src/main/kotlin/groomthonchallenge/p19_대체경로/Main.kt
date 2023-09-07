package groomthonchallenge.p19_대체경로

import java.util.HashSet
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
    val preNode = IntArray(n + 1) { -1 }

    // 0번 도시가 공사중 -> 아무 도시도 공사중이지 않은 상태를 의미
    for (blockedCity in 0..n) {
        visited.fill(0)
        preNode.fill(-1)

        visited[start] = 1

        val q = LinkedList<Int>() as Queue<Int>
        q.offer(start)

        bfs@ while (q.isNotEmpty()) {
            val currentCity = q.poll()

            for (i in 0 until connect[currentCity].size) {
                val nextCity = connect[currentCity][i]

                if (visited[nextCity] != 0 || nextCity == blockedCity) continue

                visited[nextCity] = visited[currentCity] + 1
                preNode[nextCity] = currentCity
                q.offer(nextCity)

                if (nextCity == end) {
                    val visitedCity = HashSet<Int>()
                    var pre = end

                    while (pre != -1) {
                        visitedCity.add(pre)
                        pre = preNode[pre]
                    }

                    for (j in 1..n) {
                        if (j in visitedCity) continue
                        minDistanceWhenCityBlocked[j] = minOf(minDistanceWhenCityBlocked[j], visited[end])
                    }

                    break@bfs
                }
            }
        }
    }

    val sb = StringBuilder()
    for (i in 1..n) {
        if (minDistanceWhenCityBlocked[i] == Int.MAX_VALUE) sb.append(-1).append("\n")
        else sb.append(minDistanceWhenCityBlocked[i]).append("\n")
    }
    print(sb)
}