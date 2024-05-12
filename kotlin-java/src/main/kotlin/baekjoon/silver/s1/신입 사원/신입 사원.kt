package baekjoon.silver.s1.`신입 사원`

import java.util.*

class Person(var document: Int, var interview: Int) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return document - other.document
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()

    repeat(readLine().toInt()) {
        val n = readLine().toInt()

        val arr = Array(n) {
            val st = StringTokenizer(readLine())
            Person(st.nextToken().toInt(), st.nextToken().toInt())
        }.sorted().toTypedArray()

        var cnt = 1
        var min = arr[0].interview

        for (i in 1 until n) {
            if (arr[i].interview < min) {
                min = arr[i].interview
                cnt++
            }
        }

        sb.append("$cnt\n")
    }

    print(sb)
}