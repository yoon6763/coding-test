package baekjoon.silver.s3

fun main() {
    val (n, x) = readln().split(" ").map { it.toInt() }
    val today = readln().split(" ").map { it.toLong() }
    var max = today.subList(0, x).sum()
    var sum = max
    var cnt = 1

    for (i in x until n) {
        sum += today[i] - today[i - x]
        if (sum > max) {
            max = sum
            cnt = 1
        } else if (sum == max) cnt++
    }

    if (max == 0L) println("SAD")
    else {
        println(max)
        println(cnt)
    }
}