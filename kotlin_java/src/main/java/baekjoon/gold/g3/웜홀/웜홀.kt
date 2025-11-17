package baekjoon.gold.g3.웜홀

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

data class Edge(var to: Int, var weight: Int)

var n = 0
var m = 0
var w = 0
lateinit var dist: Array<Int>
lateinit var edgeList: ArrayList<ArrayList<Edge>>
const val MAX_VALUE = 987654321

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val T = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val st = StringTokenizer(br.readLine())

        n = st.nextToken().toInt()
        m = st.nextToken().toInt()
        w = st.nextToken().toInt()

        edgeList = ArrayList()

        repeat(n + 1) {
            edgeList.add(ArrayList())
        }

        dist = Array(n + 1) { MAX_VALUE }


        for (i in 0 until m) {
            val st = StringTokenizer(br.readLine())

            val from = st.nextToken().toInt()
            val to = st.nextToken().toInt()
            val weight = st.nextToken().toInt()

            edgeList[from].add(Edge(to, weight))
            edgeList[to].add(Edge(from, weight))
        }

        for (i in 0 until w) {
            val st = StringTokenizer(br.readLine())
            edgeList[st.nextToken().toInt()].add(Edge(st.nextToken().toInt(), -st.nextToken().toInt()))
        }

        var isAble = false

        for (i in 1..n) {
            if (bellmanFord(i)) {
                isAble = true
                sb.append("YES\n")
                break
            }
        }

        if (!isAble) sb.append("NO\n")
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}

fun bellmanFord(start: Int): Boolean {
    // 자기 자신으로의 비용은 0
    dist[start] = 0
    var isUpdated = false

    for (i in 1 until n) {
        isUpdated = false

        for (j in 1..n) {
            for (k in 0 until edgeList[j].size) {
                if (dist[j] != MAX_VALUE && dist[edgeList[j][k].to] > dist[j] + edgeList[j][k].weight) {
                    dist[edgeList[j][k].to] = dist[j] + edgeList[j][k].weight
                    isUpdated = true
                }
            }
        }

        if (!isUpdated) break
    }

    if (isUpdated) {
        for (i in 1..n) {
            for (j in 0 until edgeList[i].size) {
                if (dist[i] != MAX_VALUE && dist[edgeList[i][j].to] > dist[i] + edgeList[i][j].weight) return true
            }
        }
    }

    return false
}


/*

2
3 3 1
1 2 2
1 3 4
2 3 1
3 1 3
3 2 1
1 2 3
2 3 4
3 1 8

 */