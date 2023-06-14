package baekjoon.gold.g2

import java.lang.StringBuilder
import java.util.Collections
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val n = readLine().toInt()

        sb.append((n + 1) / 2).append("\n")

        val lowQ = PriorityQueue<Int>(Collections.reverseOrder())
        val highQ = PriorityQueue<Int>()
        var cnt = 1

        repeat(n / 10 + 1) { row ->
            val nums = readLine().split(" ").map { it.toInt() }

            for (col in nums.indices) {
                if (cnt % 20 == 0) {
                    sb.append("\n")
                }

                if (lowQ.isNotEmpty() && nums[col] > lowQ.peek()) {
                    highQ.offer(nums[col])
                } else {
                    lowQ.offer(nums[col])
                }

                while (lowQ.size < highQ.size) {
                    lowQ.offer(highQ.poll())
                }
                while (lowQ.size - 1 > highQ.size) {
                    highQ.offer(lowQ.poll())
                }

                if (cnt++ % 2 == 1) {
                    sb.append(lowQ.peek()).append(" ")
                }
            }
        }

        sb.append("\n")
    }
    print(sb)
}