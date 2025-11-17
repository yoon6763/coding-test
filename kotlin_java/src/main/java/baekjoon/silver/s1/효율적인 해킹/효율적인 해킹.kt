package baekjoon.silver.s1.`효율적인 해킹`

import java.lang.StringBuilder
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val connect = Array(n + 1) { ArrayList<Int>() }

    repeat(m) {
        st = StringTokenizer(readLine())
        val (a, b) = List(2) { st.nextToken().toInt() }
        connect[a].add(b)
    }

    val childCount = IntArray(n + 1)
    val visited = BooleanArray(n + 1)

    val q = ArrayDeque<Int>()

    for (i in 1..n) {
        visited.fill(false)
        q.add(i)
        visited[i] = true

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            for (next in connect[cur]) {
                if (visited[next]) continue
                visited[next] = true
                q.add(next)
                childCount[i]++
            }
        }
    }

    val max = childCount.maxOrNull()!!
    val sb = StringBuilder()
    for (i in 1..n) {
        if (childCount[i] == max) {
            sb.append("$i ")
        }
    }

    println(sb)
}