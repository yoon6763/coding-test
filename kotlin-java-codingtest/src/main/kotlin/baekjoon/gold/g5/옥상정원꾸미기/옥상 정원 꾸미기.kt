package baekjoon.gold.g5.옥상정원꾸미기

import java.util.*

data class Rooftop(val idx: Int, val num: Long)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { readLine().toLong() }
    val answer = LongArray(n)
    val stack = Stack<Rooftop>()

    for (i in 0 until n) {
        while (stack.isNotEmpty() && stack.peek().num <= arr[i]) {
            val target = stack.pop()
            answer[target.idx] = (i - target.idx - 1).toLong()
        }
        stack.add(Rooftop(i, arr[i]))
    }

    while (stack.isNotEmpty()) {
        val target = stack.pop()
        answer[target.idx] = (n - target.idx - 1).toLong()
    }
    println(answer.sum())
}