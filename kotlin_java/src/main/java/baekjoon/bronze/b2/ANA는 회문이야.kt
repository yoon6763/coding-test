package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val s = readln()

    var count = 0

    for (i in 0 until n) {
        if (s[i] != 'A') continue

        a@ for (j in i + 2 until n) {
            if (s[j] != 'A') continue

            var nCnt = 0

            for (k in i + 1 until j) {
                if (s[k] == 'A') continue@a
                if (s[k] == 'N') nCnt++
            }

            if (nCnt == 1) count++
        }
    }

    println(count)
}