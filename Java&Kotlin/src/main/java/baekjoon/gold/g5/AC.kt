package baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val sb = StringBuilder()

    for (t in 0 until T) {
        val deque = ArrayDeque<Int>()

        val oper = br.readLine()
        val n = br.readLine().toInt()
        var line = br.readLine()
        line = line.substring(1, line.length - 1)
        val st = StringTokenizer(line, ",")

        repeat(n) {
            deque.addLast(st.nextToken().toInt())
        }

        var isReverse = false
        var isError = false

        for (i in 0 until oper.length) {
            if (oper[i] == 'R') {
                isReverse = !isReverse
            } else {
                if (deque.size == 0) {
                    isError = true
                    break
                }

                // D
                if (isReverse) {
                    deque.removeLast()
                } else {
                    deque.removeFirst()
                }
            }
        }

        if (isError) {
            sb.append("error").append("\n")
            continue
        }
        sb.append("[")

        if (isReverse) {
            for (i in deque.size - 1 downTo 0) {
                if (i != 0)
                    sb.append("${deque[i]},")
                else
                    sb.append("${deque[i]}")
            }
        } else {
            for (i in 0 until deque.size) {
                if (i != deque.size - 1)
                    sb.append("${deque[i]},")
                else
                    sb.append("${deque[i]}")
            }
        }
        sb.append("]").append("\n")
    }
    print(sb.toString())
}