package baekjoon.bronze.b3

fun main() {
    while (true) {
        val line = readln()
        if (line == "0") break

        var ans = 0
        for (ch in line) {
            ans += when (ch) {
                '0' -> 4
                '1' -> 2
                else -> 3
            }
        }
        println(ans + line.length + 1)
    }
}