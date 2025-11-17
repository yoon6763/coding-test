package baekjoon.bronze.b3

fun main() {
    repeat(readln().toInt()) {
        var cnt = 0
        val (n, m) = readln().split(" ").map { it.toInt() }
        for (i in 1..<n) {
            for (j in i + 1..<n) {
                if ((i * i + j * j + m) % (i * j) == 0) {
                    cnt++
                }
            }
        }
        println(cnt)
    }
}