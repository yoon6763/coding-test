package baekjoon.silver.s3

fun main() {
    val max = 123456 * 2
    val map = Array(max + 1) { false }
    for (i in 2..max) {
        map[i] = true
    }


    for (i in 2..max) {
        for(j in i * 2 .. max step i) {
            if(!map[j]) continue
            map[j] = false
        }
    }


    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0) break

        var cnt = 0

        for (i in n + 1..2 * n) {
            if (map[i]) cnt++
        }
        println(cnt)
    }
}