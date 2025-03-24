package baekjoon.gold.g1.트리

import java.util.StringTokenizer

lateinit var preOrder: Array<Int>
lateinit var inOrder: Array<Int>
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        var st = StringTokenizer(readLine())
        preOrder = Array(n + 1) { if (st.hasMoreTokens()) st.nextToken().toInt() else 0 }
        st = StringTokenizer(readLine())
        inOrder = Array(n + 1) { if (st.hasMoreTokens()) st.nextToken().toInt() else 0 }
        postOrder(0, 0, n)
        sb.append("\n")
    }
    print(sb)
}

fun postOrder(root: Int, start: Int, end: Int) {
    val rootIdx = preOrder[root]

    for (i in start until end) {
        if (rootIdx == inOrder[i]) {
            postOrder(root + 1, start, i)
            postOrder(root + i + 1 - start, i + 1, end)
            sb.append("$rootIdx ")
        }
    }
}