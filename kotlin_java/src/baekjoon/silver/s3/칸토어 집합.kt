package baekjoon.silver.s3

import kotlin.math.pow

fun main() = generateSequence(::readLine).map { it.toDouble() }.forEach { n ->
    val length = 3.0.pow(n).toInt()
    val arr = CharArray(length) { '-' }

    fun removeMiddle(start: Int, end: Int) {
        val size = end - start
        if (size < 3) return

        val part = size / 3
        for (i in start + part..<start + 2 * part) {
            arr[i] = ' '
        }

        removeMiddle(start, start + part)
        removeMiddle(start + 2 * part, end)
    }

    removeMiddle(0, length)
    println(arr.joinToString(""))
}

