package baekjoon.silver.s5

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (aSize, bSize) = readLine().split(" ").map { it.toInt() }
    var aPtr = 0
    var bPtr = 0

    val aArray = Array(aSize) { 0L }
    val bArray = Array(bSize) { 0L }

    var st = StringTokenizer(readLine())
    for (i in 0 until aSize) {
        aArray[i] = st.nextToken().toLong()
    }
    st = StringTokenizer(readLine())
    for (i in 0 until bSize) {
        bArray[i] = st.nextToken().toLong()
    }

    aArray.sort()
    bArray.sort()

    val sb = StringBuilder()

    while (aPtr < aSize && bPtr < bSize) {
        if (aArray[aPtr] > bArray[bPtr]) {
            sb.append("${bArray[bPtr++]} ")
        } else {
            sb.append("${aArray[aPtr++]} ")
        }
    }

    while (aPtr < aSize) {
        sb.append("${aArray[aPtr++]} ")
    }
    while (bPtr < bSize) {
        sb.append("${bArray[bPtr++]} ")
    }
    println(sb)
}