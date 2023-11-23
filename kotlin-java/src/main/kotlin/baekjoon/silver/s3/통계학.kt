package baekjoon.silver.s3

import baekjoon.cnt
import kotlin.math.roundToInt

data class NumWithCnt(val num: Int, var cnt: Int)

fun main() {
    val n = readLine()!!.toInt()
    val arr = Array<Int>(n) { 0 }
    val cntList = ArrayList<NumWithCnt>()

    for (i in 0 until n) {
        arr[i] = readLine()!!.toInt()
    }

    arr.sort()
    println(arr.average().roundToInt())
    println(arr[n / 2])

    cntList.add(NumWithCnt(arr[0], 1))

    for (i in 1 until n) {
        if (arr[i - 1] == arr[i]) {
            cntList.last().cnt += 1
        } else {
            cntList.add(NumWithCnt(arr[i], 1))
        }
    }

    val cntMax = cntList.maxOf { it.cnt }
    val maxCount = cntList.count { it -> it.cnt == cntMax }

    if (maxCount >= 2) {
        var temp = 0
        for (i in 0 until cntList.size) {
            if (cntList[i].cnt == cntMax) {
                temp++
                if (temp == 2) {
                    println(cntList[i].num)
                }
            }
        }
    } else {
        println(cntList.find { it.cnt == cntMax }!!.num)
    }

    println(arr.last() - arr.first())
}