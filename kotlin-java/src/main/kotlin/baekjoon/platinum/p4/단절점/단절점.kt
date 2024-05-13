package baekjoon.platinum.p4.`단절점`

import java.util.*

var order = 1
lateinit var cutNode: BooleanArray
lateinit var graph: Array<ArrayList<Int>>
lateinit var orderArr: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val (v, e) = List(2) { st.nextToken().toInt() }

    cutNode = BooleanArray(v + 1)
    graph = Array(v + 1) { arrayListOf() }
    orderArr = IntArray(v + 1)

    repeat(e) {
        st = StringTokenizer(readLine())
        val (a, b) = List(2) { st.nextToken().toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    for (i in 1..v) {
        if (orderArr[i] == 0) {
            dfs(i, true)
        }
    }

    val sb = StringBuilder()
    var cnt = 0
    for (i in 1..v) {
        if (cutNode[i]) {
            cnt++
            sb.append(i).append(" ")
        }
    }

    println(cnt)
    println(sb)
}

fun dfs(node: Int, isRoot: Boolean): Int {
    orderArr[node] = order++
    var ret = orderArr[node]
    var child = 0

    for (next in graph[node]) {
        if (orderArr[next] != 0) {
            ret = minOf(ret, orderArr[next])
            continue
        }

        child++
        val low = dfs(next, false)
        if (!isRoot && low >= orderArr[node]) {
            cutNode[node] = true
        }

        ret = minOf(ret, low)
    }

    if (isRoot && child >= 2) {
        cutNode[node] = true
    }

    return ret
}