package baekjoon.bronze.b3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        sb.append("Pairs for $n: ")
        var first = false

        for (i in 1 until n) {
            if(i >= n - i) break
            if (i + (n - i) == n) {
                if (first) sb.append(", ")
                sb.append("$i ${n - i}")
                first = true
            }
        }
        sb.append("\n")
    }
    print(sb)
}