package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val arr = readLine().split(" ").map { it.toInt() }
        if (arr[0] == -1) break
        var cnt = 0
        for (i in 0..<arr.size) {
            for (j in 0..<arr.size) {
                if (i == j) continue
                if (arr[i] == arr[j] * 2) cnt++
            }
        }
        sb.appendLine(cnt)
    }

    print(sb)
}