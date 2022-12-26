package baekjoon.bronze.b3

fun main() {
    val line = readln()
    val first = line[0]
    var cnt = 1

    while (cnt < line.length) {
        if (line[cnt] != first) {
            break
        }
        cnt++
    }

    println(cnt)
}