package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val s = readln()
    val target = "eagle"

    var answer = Int.MAX_VALUE

    for (i in 0..n - 5) {
        var diff = 0
        for (j in 0 until 5) {
            if (s[i + j] != target[j]) diff++
        }
        answer = minOf(answer, diff)
    }

    println(answer)
}