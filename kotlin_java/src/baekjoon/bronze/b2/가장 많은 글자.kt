package baekjoon.bronze.b2

fun main() = with(System.`in`.bufferedReader()) {
    var line: String? = ""
    val cnt = Array(26) { 0 }

    while (true) {
        line = readLine()
        if (line == null) break
        for (ch in line) {
            if (ch == ' ') continue
            cnt[ch - 'a']++
        }
    }

    val max = cnt.maxOrNull()!!
    cnt.forEachIndexed { index, i ->
        if (i == max) print((index + 'a'.toInt()).toChar())
    }
}