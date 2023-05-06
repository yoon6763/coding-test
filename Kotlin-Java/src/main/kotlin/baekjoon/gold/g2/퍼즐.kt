package baekjoon.gold.g2

import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {

    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)

    val nums = Array(9) { ' ' }
    repeat(3) { i ->
        val st = StringTokenizer(readLine())
        repeat(3) { j ->
            val n = st.nextToken()[0]
            nums[i * 3 + j] = if (n == '0') '9' else n
        }
    }

    val q = LinkedList<String>() as Queue<String>
    val map = HashMap<String, Int>()

    q.offer(nums.joinToString(""))
    map[nums.joinToString("")] = 0

    while (q.isNotEmpty()) {
        val target = q.poll()
        val nineIdx = target.indexOf("9")

        // 인덱스 -> 좌표화
        val x = nineIdx / 3
        val y = nineIdx % 3

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until 3 || ny !in 0 until 3) continue

            val newIdx = nx * 3 + ny // 좌표 -> 인덱스화

            val charArray = target.toCharArray()
            charArray[nineIdx] = charArray[newIdx]
            charArray[newIdx] = '9'

            val newString = charArray.joinToString("")

            if (newString !in map) {
                map[newString] = map[target]!! + 1
                q.offer(newString)
            }
        }
    }

    println(map.getOrDefault("123456789", -1))
}