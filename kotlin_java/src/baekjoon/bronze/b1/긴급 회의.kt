package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val vote = Array(n + 1) { 0 }

    for (i in 0 until n) {
        if (arr[i] == 0) continue
        vote[arr[i]]++
    }

    val max = vote.maxOrNull()!!
    if (vote.count { it == max } > 1) {
        println("skipped")
    } else {
        println(vote.indexOf(max))
    }
}