package baekjoon.bronze.b3

fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val line = readln()
    var idx = 0
    while (idx < n - 1) {
        if (line[idx] == line[idx + 1]) {
            sb.append(line[idx].uppercase().repeat(2))
            idx += 2
        } else {
            sb.append(line[idx])
            idx++
        }
    }
    if (idx == n - 1)
    sb.append(line[idx])
    println(sb)
}