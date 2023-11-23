package baekjoon.silver.s2

fun main() {
    val line = readln()
    var depth = 0
    var cnt = 0

    for (i in line.indices) {
        if (line[i] == '(') depth++
        else {
            depth--
            if (line[i - 1] == '(') cnt += depth
            else cnt++
        }
    }

    println(cnt)
}
