package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val arr = Array(n) { IntArray(2) }

    repeat(m) {
        val (k, s, e) = readLine().split(" ").map { it.toInt() }

        if (arr[k - 1][1] > s) {
            sb.append("NO\n")
        } else {
            arr[k - 1][0] = s
            arr[k - 1][1] = e
            sb.append("YES\n")
        }
    }

    print(sb)
}