package baekjoon.platinum.p5

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val visited = BooleanArray(n + 1)
        val path = Array(n + 1) { IntArray(2) }
        val q = ArrayDeque<Int>()
        q.add(1)
        visited[1] = true

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            if (cur == 0) break

            for (i in 0..1) {
                val next = (cur * 10 + i) % n
                if (!visited[next]) {
                    visited[next] = true
                    path[next][0] = cur
                    path[next][1] = i
                    q.add(next)
                }
            }
        }

        var cur = 0
        val line = StringBuilder()
        while (cur != 1) {
            line.append(path[cur][1])
            cur = path[cur][0]
        }

        sb.appendLine(line.append(1).reverse())
    }

    print(sb)
}