package baekjoon.platinum.p5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    var max = 0L

    val n = br.readLine().toInt()

    val histogram = Array(n) { 0 }
    repeat(n) {
        histogram[it] = br.readLine().toInt()
    }

    val stack = Stack<Int>()

    repeat(n) {
        while (stack.isNotEmpty() && histogram[stack.peek()] >= histogram[it]) {
            val h = histogram[stack.pop()].toLong()
            val w = if (stack.isEmpty()) it else it - 1 - stack.peek()

            if (max < w * h) max = w * h
        }
        stack.push(it)
    }

    while (stack.isNotEmpty()) {
        val h = histogram[stack.pop()].toLong()
        val w = if (stack.isEmpty()) n else n - 1 - stack.peek()
        if (max < w * h) max = w * h
    }

    sb.append("$max\n")
    print(sb)
}