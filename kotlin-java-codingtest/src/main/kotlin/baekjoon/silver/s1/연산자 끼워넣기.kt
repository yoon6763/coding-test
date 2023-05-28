package baekjoon.silver.s1

import java.util.*
import kotlin.math.max
import kotlin.math.min

lateinit var operCnt: Array<Int>
lateinit var arr: Array<Int>
var max = Long.MIN_VALUE
var min = Long.MAX_VALUE
var n = 0

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    arr = Array(n) { 0 }
    var st = StringTokenizer(readLine())
    repeat(n) {
        arr[it] = st.nextToken().toInt()
    }

    operCnt = Array(4) { 0 }
    st = StringTokenizer(readLine())
    repeat(4) {
        operCnt[it] = st.nextToken().toInt()
    }

    backTracking(0, Array(n) { 0 })

    println(max)
    println(min)
}

fun backTracking(depth: Int, oper: Array<Int>) {
    if (depth == n - 1) {
        var result = arr[0].toLong()

        repeat(n - 1) {
            // 덧셈 뺄셈 곱셈 나눗셈
            when (oper[it]) {
                0 -> result += arr[it + 1]
                1 -> result -= arr[it + 1]
                2 -> result *= arr[it + 1]
                3 -> result /= arr[it + 1]
            }
        }

        max = max(max, result)
        min = min(min, result)

        return
    }

    for (i in 0 until 4) {
        if (operCnt[i] > 0) {
            operCnt[i]--
            val operCopy = Array(oper.size) { 0 }

            repeat(operCopy.size) {
                operCopy[it] = oper[it]
            }

            operCopy[depth] = i
            backTracking(depth + 1, operCopy)
            operCnt[i]++
        }
    }
}