package baekjoon.platinum.p5.`전깃줄 - 2`

import java.util.*

class Wire(val left: Int, val right: Int) : Comparable<Wire> {
    override fun compareTo(other: Wire): Int {
        return this.left - other.left
    }
}

lateinit var wires: List<Wire>
lateinit var lis: IntArray
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    lis = IntArray(n)
    val visited = BooleanArray(500001)
    val trace = arrayOfNulls<Wire>(n)
    val sb = StringBuilder()

    wires = Array(n) {
        val st = StringTokenizer(readLine())
        val (left, right) = st.nextToken().toInt() to st.nextToken().toInt()
        val wire = Wire(left, right)
        visited[left] = true
        wire
    }.sorted()

    var idx = 0

    lis[idx] = wires[0].right
    trace[0] = Wire(0, wires[0].left)
    for (i in 1..<n) {
        if (lis[idx] < wires[i].right) {
            lis[++idx] = wires[i].right
            trace[i] = Wire(idx, wires[i].left)
        } else {
            val temp = lowerBound(0, idx, wires[i].right)
            lis[temp - 1] = wires[i].right
            trace[i] = Wire(temp - 1, wires[i].left)
        }
    }
    sb.appendLine(n - (idx + 1))

    val list = ArrayList<Int>()
    for (i in n - 1 downTo 0) {
        if (trace[i]!!.left == idx) {
            list.add(trace[i]!!.right)
            idx--
        }
    }

    list.forEach { visited[it] = false }

    for (i in 0..500000) {
        if (visited[i]) sb.appendLine(i)
    }

    print(sb)
}

fun lowerBound(left: Int, right: Int, v: Int): Int {
    var left = left
    var right = right
    while (left < right) {
        val mid = (left + right) / 2
        if (lis[mid] >= v) right = mid
        else left = mid + 1
    }

    return right + 1
}