package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }

    val firstPos = IntArray(n + 1) { -1 }
    var answer = 0

    for (i in arr.indices) {
        val v = arr[i]

        if (firstPos[v] == -1) {
            firstPos[v] = i
        } else {
            val dist = i - firstPos[v] - 1
            if (dist > answer) answer = dist
        }
    }

    println(answer)
}