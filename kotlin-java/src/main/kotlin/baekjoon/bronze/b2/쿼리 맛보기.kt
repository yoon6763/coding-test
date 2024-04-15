package baekjoon.bronze.b2

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val students = readln().split(" ").map { it.toLong() }.toTypedArray()

    repeat(m) {
        val st = StringTokenizer(readln())
        if (st.nextToken().toInt() == 1) {
            val (a, b) = st.nextToken().toInt() to st.nextToken().toInt()
            var sum = students.slice(a - 1 until b).sum()
            var temp = students[a - 1]
            students[a - 1] = students[b - 1]
            students[b - 1] = temp
            println(sum)
        } else {
            val (a, b, c, d) = Array(4) { st.nextToken().toInt() }
            println(students.slice(a - 1 until b).sum() - students.slice(c - 1 until d).sum())
        }
    }
}