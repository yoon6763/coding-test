package baekjoon.gold.g2.`연료 채우기`

import java.util.Comparator
import java.util.PriorityQueue
import java.util.StringTokenizer

data class Station(val distance: Int, val fuel: Int) : Comparable<Station> {
    override fun compareTo(other: Station): Int {
        return this.distance - other.distance
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val stations = PriorityQueue<Station>()
    val fuels = PriorityQueue<Int>(Comparator.reverseOrder())

    repeat(n) {
        val st = StringTokenizer(readLine())
        stations.offer(Station(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    var (goal, nowDistance) = readLine().split(" ").map { it.toInt() }
    var cnt = 0

    while (goal > nowDistance) {
        while (stations.isNotEmpty() && stations.peek().distance <= nowDistance) {
            fuels.add(stations.poll().fuel)
        }

        if (fuels.isNotEmpty()) {
            nowDistance += fuels.poll()
            cnt++
        } else {
            println(-1)
            return
        }
    }

    println(cnt)
}
