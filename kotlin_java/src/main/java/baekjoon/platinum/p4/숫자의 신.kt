package baekjoon.platinum.p4

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine() }.apply { Arrays.sort(this) { o1: String, o2: String -> (o2 + o1).compareTo(o1 + o2) } }
    val max = arr.maxOf { it.toInt() }

    val sb = StringBuilder()
    var flag = false

    arr.forEach {
        sb.append(it)
        if (max == it.toInt() && !flag) {
            sb.append(it.repeat(k - n))
            flag = true
        }
    }

    println(sb)
}