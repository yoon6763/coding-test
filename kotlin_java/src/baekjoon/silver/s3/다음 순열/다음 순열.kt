package baekjoon.silver.s3.`다음 순열`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }

    println(if (find(arr)) arr.joinToString(" ") else -1)
}

fun find(arr: IntArray): Boolean {
    var i = arr.size - 1

    while (i > 0 && arr[i - 1] >= arr[i]) {
        i -= 1
    }
    if (i <= 0) return false
    var j = arr.size - 1
    while (arr[i - 1] >= arr[j]) {
        j -= 1
    }

    var temp = arr[j]
    arr[j] = arr[i - 1]
    arr[i - 1] = temp
    j = arr.size - 1

    while (i < j) {
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i += 1
        j -= 1
    }

    return true
}