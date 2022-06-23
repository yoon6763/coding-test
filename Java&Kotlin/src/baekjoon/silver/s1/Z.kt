package baekjoon.silver.s1

import kotlin.math.pow

fun main() {
    val nrc = readLine()!!.split(" ")
    val n = nrc[0].toInt()
    val r = nrc[1].toInt()
    val c = nrc[2].toInt()

    println(find(2.0.pow(n).toInt(), r, c, 0))
}

fun find(n: Int, r: Int, c: Int, cnt: Int): Int {
    return if (n == 1)
        cnt
    else if (r < n / 2 && c < n / 2)
        find(n / 2, r, c, cnt)
    else if (r < n / 2)
        find(n / 2, r, c - n / 2, cnt + (n / 2) * (n / 2))
    else if (c < n / 2)
        find(n / 2, r - n / 2, c, cnt + (n / 2) * (n / 2) * 2)
    else
        find(n / 2, r - n / 2, c - n / 2, cnt + (n / 2) * (n / 2) * 3)
}