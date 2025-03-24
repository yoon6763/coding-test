package baekjoon.silver.s3

import java.util.*
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val st = StringTokenizer(readLine())
        val (x1, y1, r1) = IntArray(3) { st.nextToken().toInt() }
        val (x2, y2, r2) = IntArray(3) { st.nextToken().toInt() }

        val distanceBetweenPoints = (x2 - x1).toDouble().pow(2.0) + (y2 - y1).toDouble().pow(2.0)

        when {
            // 두 원의 중심이 같을 때
            x1 == x2 && y1 == y2 && r1 == r2 -> println(-1) // 두 원이 일치
            x1 == x2 && y1 == y2 && r1 != r2 -> println(0) // 두 원이 서로 다름

            distanceBetweenPoints > (r1 + r2).toDouble().pow(2.0) -> println(0)
            distanceBetweenPoints < (r1 - r2).toDouble().pow(2.0) -> println(0)
            distanceBetweenPoints == (r1 + r2).toDouble().pow(2.0) -> println(1)
            distanceBetweenPoints == (r1 - r2).toDouble().pow(2.0) -> println(1)

            else -> println(2)
        }
    }
}