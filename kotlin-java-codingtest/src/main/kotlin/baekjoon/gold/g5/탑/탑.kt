package baekjoon.gold.g5.탑

import java.util.Stack

data class Tower(val idx: Int, val num: Int)

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val answer = IntArray(n)
    val stack = Stack<Tower>()

    for (i in n - 1 downTo 0) {
        while (stack.isNotEmpty() && stack.peek().num < arr[i]) {
            val target = stack.pop()
            answer[target.idx] = (i + 1)
        }
        stack.add(Tower(i, arr[i]))
    }
    println(answer.joinToString(" "))
}
