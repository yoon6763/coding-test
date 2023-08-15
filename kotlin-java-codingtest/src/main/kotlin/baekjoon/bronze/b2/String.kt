package baekjoon.bronze.b2

fun main() {
    val sb = StringBuilder()
    val line = readln()
    for (i in 1 until line.length) {
        if (line[i - 1] != line[i]) sb.append(line[i - 1])
    }
    sb.append(line.last())
    print(sb)
}