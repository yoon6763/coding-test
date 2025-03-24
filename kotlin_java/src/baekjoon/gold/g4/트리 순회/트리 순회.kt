package baekjoon.gold.g4.`트리 순회`

lateinit var left: IntArray
lateinit var right: IntArray
var n = 0
var answer = 0
var rightCount = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    left = IntArray(n + 1) { -1 }
    right = IntArray(n + 1) { -1 }

    for (i in 1..n) {
        val (cur, l, r) = readLine().split(" ").map { it.toInt() }
        left[cur] = l
        right[cur] = r
    }

    preorder(1)
    rightPath(1)
    println(answer - rightCount)
}

fun preorder(cur: Int) {
    answer++

    if (left[cur] != -1) {
        preorder(left[cur])
        answer++
    }
    if (right[cur] != -1) {
        preorder(right[cur])
        answer++
    }
}

fun rightPath(cur: Int) {
    if (cur == -1) return
    rightCount++
    rightPath(right[cur])
}