package baekjoon.bronze.b2

fun main() {
    var line: String
    while (readln().also { line = it } != "0 0") {
        val (m, n) = line.split(" ").map { it.toInt() }
        var x = 0
        var y = 0

        for (i in m..n) {
            var cnt = 0
            for (j in 1..i) {
                if (i % j == 0) cnt++
            }

            if (cnt >= y) {
                y = cnt
                x = i
            }
        }

        println("$x $y")
    }
}
