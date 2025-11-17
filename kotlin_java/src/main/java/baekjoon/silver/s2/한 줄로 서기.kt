package baekjoon.silver.s2

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val ans = IntArray(n)

    for (i in 0..<n) {
        var leftCnt = arr[i]

        for (j in 0..<n) {
            if (leftCnt == 0 && ans[j] == 0) {
                ans[j] = i + 1
                break
            } else if (ans[j] == 0) {
                leftCnt--
            }
        }
    }

    println(ans.joinToString(" "))
}