package baekjoon.platinum.p5.카드_게임

import java.util.StringTokenizer

lateinit var parent: IntArray
lateinit var selectedCard: IntArray

var n = 0
var m = 0
var k = 0

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    k = st.nextToken().toInt()

    st = StringTokenizer(readLine())
    selectedCard = IntArray(m) { st.nextToken().toInt() }.sortedArray()
    parent = IntArray(n + 1) { it }

    val sb = StringBuilder()
    val cardSequence = StringTokenizer(readLine())

    for (i in 0 until k) {
        val card = cardSequence.nextToken().toInt()
        val idx = find(binarySearch(card))

        sb.appendLine(selectedCard[idx])
        union(idx, idx + 1)
    }

    print(sb)
}

fun binarySearch(target: Int): Int {
    var left = 0
    var right = selectedCard.size - 1

    while (left <= right) {
        val mid = (left + right) / 2

        if (target >= selectedCard[mid]) left = mid + 1
        else right = mid - 1
    }

    return left
}

fun find(x: Int): Int {
    if (parent[x] == x) return x
    parent[x] = find(parent[x])
    return parent[x]
}

fun union(x: Int, y: Int) {
    val (px, py) = find(x) to find(y)
    if (px == py) return
    if (px > py) parent[py] = px
    else parent[px] = py
}