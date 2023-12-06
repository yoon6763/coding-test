package baekjoon.gold.g1

lateinit var map: Array<LongArray>
var MODE = 1000000007

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toLong()
    map = Array(8) { LongArray(8) }
    map[0][1] = 1
    map[0][2] = 1
    map[1][0] = 1
    map[1][2] = 1
    map[1][3] = 1
    map[2][0] = 1
    map[2][1] = 1
    map[2][3] = 1
    map[2][5] = 1
    map[3][1] = 1
    map[3][2] = 1
    map[3][4] = 1
    map[3][5] = 1
    map[4][3] = 1
    map[4][5] = 1
    map[4][6] = 1
    map[5][2] = 1
    map[5][3] = 1
    map[5][4] = 1
    map[5][7] = 1
    map[6][4] = 1
    map[6][7] = 1
    map[7][5] = 1
    map[7][6] = 1

    var arr = Array(8) { LongArray(8) }

    for (i in 0..7) {
        for (j in 0..7) {
            arr[i][j] = map[i][j]
        }
    }

    arr = solve(arr, n)
    println(arr[0][0])
}


fun multi(arr1: Array<LongArray>, arr2: Array<LongArray>): Array<LongArray> {
    val res = Array(8) { LongArray(8) }
    for (i in 0..7) {
        for (j in 0..7) {
            for (k in 0..7) res[i][j] = (res[i][j] + arr1[i][k] * arr2[k][j]) % MODE
        }
    }
    return res
}

fun solve(arr: Array<LongArray>, n: Long): Array<LongArray> {
    return if (n == 1L) arr else {
        if (n % 2 == 1L) {
            val res = multi(arr, arr)
            multi(arr, solve(res, n / 2))
        } else {
            val res = multi(arr, arr)
            solve(res, n / 2)
        }
    }
}