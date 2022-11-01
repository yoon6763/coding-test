package baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val arr = Array(n) { 0 }
    val resultArr = Array(n) { -1 }

    val stack = Stack<Int>()

    repeat(n) { i ->
        arr[i] = st.nextToken().toInt()

        while (stack.isNotEmpty() && arr[stack.peek()] < arr[i]) {
            resultArr[stack.pop()] = arr[i]
        }

        stack.add(i)
    }

    val sb = StringBuilder()
    resultArr.forEach { sb.append("$it ") }
    println(sb)
}