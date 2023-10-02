package programmers.lv3.이중우선순위큐

import java.util.Collections
import java.util.PriorityQueue

fun solution(operations: Array<String>): IntArray {
    val max = PriorityQueue<Int>(Collections.reverseOrder())
    val min = PriorityQueue<Int>()

    operations.forEach { oper ->
        val (cmd, snum) = oper.split(" ")
        val num = snum.toInt()

        if (cmd == "I") {
            max.add(num)
            min.add(num)
        } else {
            if (max.isEmpty()) return@forEach
            if (num > 0) max.remove(min.poll())
            else min.remove(max.poll())
        }
    }

    return if (max.isEmpty()) intArrayOf(0, 0)
    else intArrayOf(max.peek(),min.peek())
}