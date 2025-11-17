package baekjoon.bronze.b3

fun main() {
    var cnt = 0
    var max = 0
    repeat(4) {
        val (outCnt, inCnt) = readln().split(" ").map { it.toInt() }
        cnt += inCnt - outCnt
        max = maxOf(max, cnt)
    }
    println(max)
}