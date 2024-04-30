package baekjoon.bronze.b3

fun main() {
    var mCnt = 0
    var jCnt = 0
    var mSum = 0L
    var jSum = 0L

    repeat(readln().toInt()) {
        val (c, p) = readln().split(" ")
        if (c == "M") {
            mCnt++
            mSum += p.toLong()
        } else {
            jCnt++
            jSum += p.toLong()
        }
    }

    if (mCnt == 0) mCnt = 1
    if (jCnt == 0) jCnt = 1

    val mAvg = mSum.toDouble() / mCnt
    val jAvg = jSum.toDouble() / jCnt

    println(if (mAvg > jAvg) 'M' else if (mAvg < jAvg) 'J' else 'V')
}