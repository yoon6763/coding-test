package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = BooleanArray(n + 1)
    var max = -1
    var maxReal = -1
    var maxIndex = 0
    var maxRealIndex = 0

    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        var cnt = 0
        for (i in a..b) {
            if (!arr[i]) {
                arr[i] = true
                cnt++
            }
        }

        if (b - a > max) {
            max = b - a
            maxIndex = it + 1
        }

        if (cnt > maxReal) {
            maxReal = cnt
            maxRealIndex = it + 1
        }
    }

    println(maxIndex)
    println(maxRealIndex)
}