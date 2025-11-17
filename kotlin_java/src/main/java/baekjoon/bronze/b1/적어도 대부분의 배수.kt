package baekjoon.bronze.b1

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    var answer = 1

    while (true) {
        var cnt = 0
        for (i in arr) if (answer % i == 0) cnt++
        if (cnt >= 3) break
        answer++
    }
    println(answer)
}