package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class MapPath(var path: Int, var oper: String)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val visited = Array(10001) { false }

    for (i in 0 until T) {
        val ab = br.readLine().split(" ")
        val a = ab[0].toInt()
        val b = ab[1].toInt()
        var lastVal = -1

        for( j in visited.indices) {
            visited[j] = false
        }

        val q = LinkedList<Int>() as Queue<Int>
        q.offer(a)
        visited[a] = true

        val path = Array(10001) { MapPath(-1, "") }

        while (q.isNotEmpty()) {
            val target = q.poll()

            // D, Double
            var d = target * 2
            if (d > 9999) d %= 10000
            if (d == b) {
                lastVal = d
                path[lastVal].oper = "D"
                path[lastVal].path = target
                break
            } else if (!visited[d]) {
                q.offer(d)
                visited[d] = true
                path[d].oper = "D"
                path[d].path = target
            }

            // S, -1
            var s = if(target == 0) 9999 else target - 1
            if (s == b) {
                lastVal = s
                path[lastVal].oper = "S"
                path[lastVal].path = target
                break
            } else if (!visited[s]) {
                q.offer(s)
                visited[s] = true
                path[s].oper = "S"
                path[s].path = target
            }

            // L
            val l = (target * 10) % 10000 + (target / 1000)

            if (l == b) {
                lastVal = l
                path[lastVal].oper = "L"
                path[lastVal].path = target
                break
            } else if (!visited[l]) {
                q.offer(l)
                visited[l] = true
                path[l].oper = "L"
                path[l].path = target
            }

            // R
            val r = (target / 10) + (target % 10) * 1000
            if (r == b) {
                lastVal = r
                path[lastVal].oper = "R"
                path[lastVal].path = target
                break
            } else if (!visited[r]) {
                q.offer(r)
                visited[r] = true
                path[r].oper = "R"
                path[r].path = target
            }
        }

        val sb = StringBuilder()

        var tmp = lastVal
        while (true) {
            sb.append(path[tmp].oper)
            tmp = path[tmp].path

            if (tmp == a || tmp == -1) break
        }
        println(sb.reverse().toString())
    }
}

/*
3
1234 3412
1000 1
1 16
 */