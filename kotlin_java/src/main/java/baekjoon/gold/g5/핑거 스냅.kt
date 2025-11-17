package baekjoon.gold.g5

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    val isPrime = BooleanArray(1000001) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..1000000) {
        if (isPrime[i]) {
            var j = 2
            while (i * j <= 1000000) {
                isPrime[i * j] = false
                j++
            }
        }
    }

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val (cnt, start, end) = List(3) { st.nextToken().toInt() }

        if (cnt in start..end && isPrime[cnt]) {
            sb.appendLine(0)
            return@repeat
        }

        val q = LinkedList<Int>() as Queue<Int>
        val visited = IntArray(1000001) { -1 }
        q.add(cnt)
        visited[cnt] = 0

        while (q.isNotEmpty()) {
            val cur = q.poll()

            intArrayOf(cur / 2, cur / 3, cur + 1, cur - 1).forEach { next ->
                if (next !in 0..1000000 || visited[next] != -1) return@forEach

                visited[next] = visited[cur] + 1
                q.add(next)

                if (next in start..end && isPrime[next]) {
                    sb.appendLine(visited[next])
                    return@repeat
                }
            }
        }

        sb.appendLine(-1)
    }

    print(sb)
}