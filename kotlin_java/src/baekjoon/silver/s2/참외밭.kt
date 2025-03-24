package baekjoon.silver.s2

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val n = readLine().toLong() // 참외 개수

    val dirLen = Array(12) { Pair(0, 0) }
    repeat(6) {
        val (dir, len) = readLine().split(" ").map { it.toInt() }
        dirLen[it] = Pair(dir, len)
        dirLen[it + 6] = Pair(dir, len)
    }

    for (i in 3 until 12) {
        if (dirLen[i].first == dirLen[i - 2].first && dirLen[i - 1].first == dirLen[i - 3].first) {
            // 전체 넓이 =
            println((dirLen[i + 1].second * dirLen[i + 2].second - dirLen[i-2].second * dirLen[i - 1].second) * n)
            break
        }
    }
}