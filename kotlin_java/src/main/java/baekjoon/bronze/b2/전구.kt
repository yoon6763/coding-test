package baekjoon.bronze.b2

fun main() {
    val m = readln().split(" ").map { it.toInt() }[1]
    val flag = "0 ${readln()}".split(" ").map { it.toInt() }.toTypedArray()
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        when (a) {
            1 -> flag[b] = c
            2 -> for (i in b..c) flag[i] = 1 - flag[i]
            3 -> for (i in b..c) flag[i] = 0
            4 -> for (i in b..c) flag[i] = 1
        }
    }

    println(flag.drop(1).joinToString(" "))
}