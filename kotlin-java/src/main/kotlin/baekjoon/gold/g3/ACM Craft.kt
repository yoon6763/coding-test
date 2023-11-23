package baekjoon.gold.g3.ACM_Craft

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val nk = br.readLine().split(" ")
        val n = nk[0].toInt() // 건물의 수
        val k = nk[1].toInt() // 규칙의 수
        val time = Array(n + 1) { 0 }

        val inDegree = Array(n + 1) { 0 }
        val connected = Array(n + 1) { ArrayList<Int>() }

        val stTime = StringTokenizer(br.readLine())
        for (i in 1..n) {
            time[i] = stTime.nextToken().toInt()
        }

        repeat(k) {
            val st = StringTokenizer(br.readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            inDegree[b]++
            connected[a].add(b)
        }

        val targetIdx = br.readLine().toInt()

        val q = LinkedList<Int>() as Queue<Int>

        for (i in 1..n) {
            if (inDegree[i] == 0) q.offer(i)
        }

        val timeResult = Array(n + 1) { time[it] }

        while (q.isNotEmpty()) {
            val target = q.poll()

            connected[target].forEach {
                timeResult[it] = max(timeResult[it], timeResult[target] + time[it])
                if (--inDegree[it] == 0) {
                    q.offer(it)
                }
            }
        }

        sb.append("${timeResult[targetIdx]}\n")
    }

    print(sb)
}