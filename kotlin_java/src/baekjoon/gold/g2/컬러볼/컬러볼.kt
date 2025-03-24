package baekjoon.gold.g2.컬러볼

import java.lang.StringBuilder
import java.util.StringTokenizer

data class Ball(val color: Int, val size: Int, val index: Int)

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    var st: StringTokenizer
    val balls = ArrayList<Ball>()

    repeat(n) {
        st = StringTokenizer(readLine())
        val (color, size) = List(2) { st.nextToken().toInt() }
        balls.add(Ball(color, size, it))
    }

    balls.sortWith(compareBy({ it.size }, { it.color }))


    val sb = StringBuilder()

    val colors = IntArray(n + 1) { 0 }
    val answer = IntArray(n) { 0 }
    val sizeSum = IntArray(2001) { 0 }
    var acc = 0

    for (i in 0 until n) {
        val size = balls[i].size
        val color = balls[i].color
        val index = balls[i].index

        colors[color] += size
        sizeSum[size] += size
        acc += size

        answer[index] = acc - colors[color] - sizeSum[size] + size
        if (i > 0 && balls[i - 1].size == size && balls[i - 1].color == color) {
            answer[index] = answer[balls[i - 1].index]
        }
    }

    answer.forEach { sb.append(it).append("\n") }
    print(sb)
}