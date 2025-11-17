package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    var answer = 0
    var continueCnt = 0
    for (i in 1..n) {
        if (arr[i - 1] == 1) {
            continueCnt++
            answer += continueCnt
        } else {
            continueCnt = 0
        }
    }

    println(answer)
}