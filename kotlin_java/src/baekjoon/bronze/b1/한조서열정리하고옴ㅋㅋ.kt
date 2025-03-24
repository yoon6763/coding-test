package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    var ans = 0

    for (i in 0..<n) {
        var cnt = 0
        for (j in i + 1..<n) {
            if (arr[i] > arr[j]) cnt++
            else break
        }
        ans = maxOf(ans, cnt)
    }
    println(ans)
}