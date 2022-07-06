package baekjoon.silver.s1

import java.util.*
import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()

    val pq = PriorityQueue<Int>(Comparator<Int> { o1, o2 ->
        if (abs(o1) > abs(o2)) {
            return@Comparator 1
        } else if (abs(o1) == abs(o2)) {
            return@Comparator o1 - o2
        } else {
            return@Comparator -1
        }
    })

    repeat(n) {
        val num = readLine()!!.toInt()

        if (num == 0) {
            if (pq.isEmpty()) {
                println(0)
            } else {
                println(pq.poll())
            }
        } else {
            pq.offer(num)
        }
    }
}