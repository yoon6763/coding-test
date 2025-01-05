package baekjoon.gold.g4

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine() }

    val (start, end) = readLine().split(" ").map { it.toInt() - 1 }

    val visited = BooleanArray(n)
    val pre = IntArray(n) { -1 }

    val q = LinkedList<Int>() as Queue<Int>
    q.add(start)
    visited[start] = true

    val isHamming = { a: String, b: String ->
        var cnt = 0
        for (i in 0..<m) {
            if (a[i] != b[i]) {
                cnt++
                if (cnt > 1) break
            }
        }
        cnt == 1
    }

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0..<n) {
            if (!visited[i] && isHamming(arr[cur], arr[i])) {
                visited[i] = true
                pre[i] = cur
                q.add(i)

                if (i == end) {
                    var idx = i
                    val path = mutableListOf<Int>()
                    while (idx != -1) {
                        path.add(idx)
                        idx = pre[idx]
                    }
                    println(path.reversed().joinToString(" ") { (it + 1).toString() })
                    return
                }
            }
        }
    }

    println(-1)
}