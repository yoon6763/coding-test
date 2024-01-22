package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    var ans = 0
    repeat(n) {
        var cnt = 0
        val line = readln()
        for (i in line.indices) {
            if (line[i] == 'f' && i < line.length - 2) {
                if (line[i + 1] == 'o' && line[i + 2] == 'r') {
                    cnt++
                }
            } else if (line[i]=='w' && i < line.length - 4) {
                if (line[i + 1] == 'h' && line[i + 2] == 'i' && line[i + 3] == 'l' && line[i + 4] == 'e') {
                    cnt++
                }
            }
        }

        ans = maxOf(ans, cnt)
    }

    println(ans)
}