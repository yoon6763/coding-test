package baekjoon.silver.s3.N과_M_4

lateinit var arr: Array<Int>

var n = 0
var m = 0

fun main() {
    val nm = readLine()!!.split(" ")
    m = nm[1].toInt()
    n = nm[0].toInt()

    arr = Array(n + 1) { i -> i }

    dfs(1, 0, "")
}

fun dfs(idx: Int, len: Int, str: String) {
    if (len == m) {
        println(str)
        return
    }

    for (i in idx..n) {
        if (len == 0)
            dfs(i, 1, arr[i].toString())
        else
            dfs(i, len + 1, "$str ${arr[i]}")
    }
}