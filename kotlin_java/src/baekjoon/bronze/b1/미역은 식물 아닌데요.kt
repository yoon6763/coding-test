package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { IntArray(2) { -1 } }

    repeat(m) {
        val (a, b, c) = readln().split(" ")
        val na = a.toInt()
        val nc = c.toInt()
        if (b == "P") arr[na][0] = nc else arr[na][1] = nc
    }

    var correct = 0
    var able = 0
    for (i in 1..n) {
        if (arr[i][0] == 1 && arr[i][1] == 0) correct++
        if (arr[i][0] != 0 && arr[i][1] != 1) able++
    }
    println("$correct $able")
}
