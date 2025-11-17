package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    val target = readLine()
    var cnt = 0
    val sb = StringBuilder()

    next@ for (i in 0..<readLine().toInt()) {
        val str = readLine()
        for (j in str.indices) if (str[j] != target[j] && target[j] != '*') continue@next
        cnt++
        sb.appendLine(str)
    }

    println(cnt)
    print(sb)
}