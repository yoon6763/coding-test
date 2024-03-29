package baekjoon.bronze.b2

fun main() {
    var res = 0
    while (true) {
        val line = readlnOrNull() ?: break
        for (i in 0..<line.length - 3) if (line[i] == 'j' && line[i + 1] == 'o' && line[i + 2] == 'k' && line[i + 3] == 'e') res++
    }
    println(res)
}
