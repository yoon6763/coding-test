package baekjoon.silver.s1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val arr1 = Array(n) {
        val line = readLine()
        Array(m) { line[it].digitToInt() }
    }
    val arr2 = Array(n) {
        val line = readLine()
        Array(m) { line[it].digitToInt() }
    }

    var able = true
    repeat(n) { x ->
        repeat(m) { y ->
            if (arr1[x][y] != arr2[x][y]) able = false
        }
    }
    if (able) {
        println(0)
        return@with
    }

    if (n < 3 || m < 3) {
        println(-1)
        return@with
    }

    var ans = 0

    for (i in 0 until n - 2) {
        for (j in 0 until m - 2) {
            if (arr1[i][j] != arr2[i][j]) {
                ans++
                for (x in i until i + 3) {
                    for (y in j until j + 3) {
                        arr1[x][y] = if (arr1[x][y] == 0) 1 else 0
                    }
                }
            }
        }
    }

    repeat(n){x->
        repeat(m){y->
            if(arr1[x][y] != arr2[x][y]) {
                println(-1)
                return@with
            }
        }
    }

    println(ans)
}