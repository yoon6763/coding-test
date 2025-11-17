package baekjoon.platinum.p5.사탕상자

import java.util.*

lateinit var tree: Array<Int>
var size = 1

fun main() = with(System.`in`.bufferedReader()) {

    while (size < 1000000) size *= 2

    tree = Array(size * 2) { 0 }

    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val cmd = st.nextToken().toInt()

        if (cmd == 1) {
            val target = st.nextToken().toInt()
            val index = get(1, size, 1, target)
            sb.append(index).append("\n")
            update(1, size, 1, index, -1)
        } else {
            update(1, size, 1, st.nextToken().toInt(), st.nextToken().toInt())
        }
    }

    print(sb)
}


fun get(left: Int, right: Int, node: Int, target: Int): Int {
    if (left == right) return left
    val mid = (left + right) / 2

    return if (tree[node * 2] >= target) get(left, mid, node * 2, target)
    else get(mid + 1, right, node * 2 + 1, target - tree[node * 2])
}

fun update(left: Int, right: Int, node: Int, target: Int, diff: Int) {
    if (target < left || right < target) return

    tree[node] += diff
    if (left != right) {
        val mid = (left + right) / 2
        update(left, mid, node * 2, target, diff)
        update(mid + 1, right, node * 2 + 1, target, diff)
    }
}