package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    var max = 0
    var cnt = 0

    repeat(n) {
        val line = readLine()
        var temp = 0

        if (line[0] == '1') temp++

        for (i in 1..<m) {
            if (line[i] == '1' && line[i - 1] == '0') {
                temp++
            }
        }

        if (temp > max) {
            max = temp
            cnt = 1
        } else if (temp == max) {
            cnt++
        }
    }

    println("$max $cnt")
}