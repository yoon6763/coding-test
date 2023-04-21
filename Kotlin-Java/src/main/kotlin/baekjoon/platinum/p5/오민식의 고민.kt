package baekjoon.platinum.p5

import java.util.*

data class Edge(val start: Int, val end: Int, val weight: Int)

fun main() = with(System.`in`.bufferedReader()) {
    // 도수 수 N, 시작 도시, 도착 도시, 교통 수단 개수
    var st = StringTokenizer(readLine())
    val (n, startCity, endCity, m) = Array(4) { st.nextToken().toInt() }

    val distance = Array(n + 1) { Long.MIN_VALUE }
    val edges = Array(m) {
        st = StringTokenizer(readLine())
        Edge(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt()) // 시작, 끝, 비용
    }

    st = StringTokenizer(readLine())
    val cityMoney = Array(n) { st.nextToken().toLong() }

    distance[startCity] = cityMoney[startCity]

    for (i in 0 until n + 100) {
        for (j in 0 until m) {
            val start = edges[j].start
            val end = edges[j].end
            val weight = edges[j].weight

            if (distance[start] == Long.MIN_VALUE) continue
            else if (distance[start] == Long.MAX_VALUE) distance[end] = Long.MAX_VALUE
            else if (distance[end] < distance[start] + cityMoney[end] - weight) {
                distance[end] = distance[start] + cityMoney[end] - weight
                if (i >= n - 1) distance[end] = Long.MAX_VALUE
            }
        }
    }

    if (distance[endCity] == Long.MIN_VALUE) println("gg")
    else if (distance[endCity] == Long.MAX_VALUE) println("Gee")
    else println(distance[endCity])
}