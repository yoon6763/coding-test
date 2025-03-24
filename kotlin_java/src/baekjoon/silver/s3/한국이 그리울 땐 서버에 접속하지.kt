package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    val pattern = readLine().split("*")
    for (i in 0 until n) {
        var line = readLine()

        if (line.startsWith(pattern[0])) {
            line = line.replaceFirst(pattern[0], "")
        } else {
            sb.append("NE").append("\n")
            continue
        }

        if (line.endsWith(pattern[1])) sb.append("DA").append("\n")
        else sb.append("NE").append("\n")
    }
    print(sb)
}