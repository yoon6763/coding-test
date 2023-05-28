package baekjoon.gold.g3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val connected = Array(n + 1) { ArrayList<Int>() }
    val inDegree = Array(n + 1) { 0 } // 진입차수
    val time = Array(n + 1) { 0 }

    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        time[i] = st.nextToken().toInt()

        while (st.hasMoreTokens()) {
            val pre = st.nextToken().toInt() // 먼저 지어져야 하는 건물
            if (pre != -1) {
                connected[pre].add(i)
                inDegree[i]++ // 진입차수 +1
            }
        }
    }
    val q = LinkedList<Int>() as Queue<Int>

    for (i in 1..n) {
        if (inDegree[i] == 0) q.offer(i)
    }

    val resultTime = Array(n + 1) { time[it] }

    while (q.isNotEmpty()) {
        val target = q.poll()

        for (i in 0 until connected[target].size) {
            val target2 = connected[target][i]
            resultTime[target2] = max(resultTime[target2], resultTime[target] + time[target2])

            if (--inDegree[target2] == 0) {
                q.offer(target2)
            }
        }
    }

    val sb = StringBuilder()
    for(i in 1 .. n) sb.append("${resultTime[i]}\n")
    print(sb)
}