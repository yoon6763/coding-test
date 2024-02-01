package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val a = readLine()
        val b = readLine()
        var cnt = 0
        for (i in a.indices) {
            if (a[i] != b[i]) cnt++
        }

        sb.append("Hamming distance is $cnt.\n")
    }

    print(sb)
}