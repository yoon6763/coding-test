package baekjoon.silver.s2

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val words = readLine()

    val leftStack = Stack<Char>()
    val rightStack = Stack<Char>()

    for (word in words) leftStack.push(word)

    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        when (st.nextToken()) {
            "L" -> if (leftStack.isNotEmpty()) rightStack.push(leftStack.pop())
            "D" -> if (rightStack.isNotEmpty()) leftStack.push(rightStack.pop())
            "B" -> if (leftStack.isNotEmpty()) leftStack.pop()
            "P" -> leftStack.push(st.nextToken()[0])
        }
    }
    println(leftStack.joinToString("") + rightStack.joinToString("").reversed())
}
