package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    var i = 0
    while (true) {
        val (l, p, v) = readLine().split(" ").map { it.toInt() }
        if (l == 0 && p == 0 && v == 0) break

        val result = (v / p) * l + if (v % p > l) l else v % p
        sb.append("Case ${++i}: $result\n")
    }
    print(sb)
}