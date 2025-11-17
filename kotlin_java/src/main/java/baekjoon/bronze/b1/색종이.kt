package baekjoon.bronze.b1

fun main() {
    val arr = Array(1001) { IntArray(1001) }
    val n = readln().toInt()
    repeat(n) { idx ->
        val (x, y, w, h) = readln().split(" ").map { it.toInt() }
        for (i in x until x + w) for (j in y until y + h) arr[i][j] = idx + 1
    }
    repeat(n) { idx ->
        var cnt = 0
        for (i in arr.indices) for (j in arr[i].indices) if (arr[i][j] == idx + 1) cnt++
        println(cnt)
    }
}