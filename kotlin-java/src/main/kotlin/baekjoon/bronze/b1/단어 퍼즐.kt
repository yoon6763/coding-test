package baekjoon.bronze.b1

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    var case = 1
    while (true) {
        val (str1, str2) = readLine() to readLine()
        if (str1 == "END" && str2 == "END") {
            break
        }
        sb.appendLine("Case ${case++}: ${if(str1.toCharArray().sorted() == str2.toCharArray().sorted()) "same" else "different"}")
    }

    print(sb)
}