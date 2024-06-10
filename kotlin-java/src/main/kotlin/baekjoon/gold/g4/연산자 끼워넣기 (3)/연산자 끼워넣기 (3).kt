package baekjoon.gold.g4.`연산자 끼워넣기 (3)`

import java.util.*
import kotlin.collections.ArrayDeque

lateinit var arr: IntArray
lateinit var oper: IntArray
lateinit var operCount: IntArray
var n = 0
val priority = intArrayOf(0, 0, 1, 1)
var max = Int.MIN_VALUE
var min = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    var st = StringTokenizer(readLine())
    arr = IntArray(n) { st.nextToken().toInt() }
    oper = IntArray(n - 1)
    st = StringTokenizer(readLine())
    operCount = IntArray(4) { st.nextToken().toInt() }

    dfs(0)
    println(max)
    println(min)
}

fun dfs(index: Int) {
    if (index == n - 1) {
        solve()
        return
    }

    for (i in 0..<4) {
        if (operCount[i] <= 0) continue
        operCount[i]--
        oper[index] = i
        dfs(index + 1)
        operCount[i]++
    }
}

val operation = arrayOf(
    { a: Int, b: Int -> a + b },
    { a: Int, b: Int -> a - b },
    { a: Int, b: Int -> a * b },
    { a: Int, b: Int -> a / b }
)

fun solve() {
    val numStack = ArrayDeque<Int>()
    val opStack = ArrayDeque<Int>()

    numStack.add(arr[0])

    for (i in 0..<n - 1) {
        while (opStack.isNotEmpty() && priority[opStack.last()] >= priority[oper[i]]) {
            val op = opStack.removeLast()
            val b = numStack.removeLast()
            val a = numStack.removeLast()
            numStack.add(operation[op](a, b))
        }
        opStack.add(oper[i])
        numStack.add(arr[i + 1])
    }

    while (opStack.isNotEmpty()) {
        val op = opStack.removeLast()
        val b = numStack.removeLast()
        val a = numStack.removeLast()
        numStack.add(operation[op](a, b))
    }

    val result = numStack.first()
    max = max.coerceAtLeast(result)
    min = min.coerceAtMost(result)
}
