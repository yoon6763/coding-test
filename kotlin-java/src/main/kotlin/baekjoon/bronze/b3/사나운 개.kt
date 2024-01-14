package baekjoon.bronze.b3

fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }

    arr.forEach {
        var cnt = 0
        val t1 = it % (a + b)
        if (t1 <= a) cnt++
        val t2 = it % (c + d)
        if (t2 <= c) cnt++
        if (t1 == 0) cnt--
        if (t2 == 0) cnt--
        println(cnt)
    }
}