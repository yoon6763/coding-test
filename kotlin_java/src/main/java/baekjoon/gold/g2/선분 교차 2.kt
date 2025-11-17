package baekjoon.gold.g2

fun main() = with(System.`in`.bufferedReader()) {
    val (x1, y1, x2, y2) = readLine().split(" ").map { it.toLong() }
    val (x3, y3, x4, y4) = readLine().split(" ").map { it.toLong() }

    println(if (isCross(x1, y1, x2, y2, x3, y3, x4, y4)) 1 else 0)
}

fun ccw(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long): Int {
    val temp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3)
    return if (temp > 0) 1 else if (temp < 0) -1 else 0
}

// 선분이 겹치는지 판단
fun isOverLab(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long, x4: Long, y4: Long): Boolean {
    return minOf(x1, x2) <= maxOf(x3, x4) &&
            minOf(x3, x4) <= maxOf(x1, x2) &&
            minOf(y1, y2) <= maxOf(y3, y4) &&
            minOf(y3, y4) <= maxOf(y1, y2)
}

fun isCross(x1: Long, y1: Long, x2: Long, y2: Long, x3: Long, y3: Long, x4: Long, y4: Long): Boolean {
    val abc = ccw(x1, y1, x2, y2, x3, y3)
    val abd = ccw(x1, y1, x2, y2, x4, y4)
    val cda = ccw(x3, y3, x4, y4, x1, y1)
    val cdb = ccw(x3, y3, x4, y4, x2, y2)

    return if (abc * abd == 0 && cda * cdb == 0) isOverLab(x1, y1, x2, y2, x3, y3, x4, y4)
    else abc * abd <= 0 && cda * cdb <= 0
}