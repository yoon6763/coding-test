package programmers.lv0.직사각형_넓이_구하기

import kotlin.math.abs

fun solution(dots: Array<IntArray>): Int {
    return maxOf(abs(dots[0][0] - dots[1][0]), abs(dots[0][0] - dots[2][0]), abs(dots[1][0] - dots[2][0])) * maxOf(abs(dots[0][1] - dots[1][1]), abs(dots[0][1] - dots[2][1]), abs(dots[1][1] - dots[2][1]))
}