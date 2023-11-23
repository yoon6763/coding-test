package baekjoon.gold.g2

import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()


    val pqMin = PriorityQueue<Int>(Collections.reverseOrder())
    val pqMax = PriorityQueue<Int>()

    val sb = StringBuilder()

    repeat(n) {
        val input = br.readLine().toInt()
        if (pqMin.size == pqMax.size) {
            pqMin.offer(input)
        } else {
            pqMax.offer(input)
        }

        if (pqMin.isNotEmpty() && pqMax.isNotEmpty() && pqMin.peek() > pqMax.peek()) {
            val tempMax = pqMax.poll()
            val tempMin = pqMin.poll()
            pqMin.offer(tempMax)
            pqMax.offer(tempMin)
        }
        sb.append(pqMin.peek()).append("\n")
    }

    print(sb)
}