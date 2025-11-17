package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln().split(" ").map { it.toInt() } }
    val ans = Array(n) { 0 }
    for (j in 0..<3) {
        for (i in 0..<n) {
            var me = arr[i][j]
            for (k in 0..<n) {
                if (i == k) continue
                if (arr[k][j] == me) {
                    me = 0
                    break
                }
            }

            ans[i] += me
        }
    }

    print(ans.joinToString("\n"))
}