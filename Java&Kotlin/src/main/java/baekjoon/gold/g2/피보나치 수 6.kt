package baekjoon.gold.g2

const val MOD = 1000000007L

var arr = arrayOf(
    arrayOf(1L, 1L),
    arrayOf(1L, 0L)
)
var result = arrayOf(
    arrayOf(1L, 0L),
    arrayOf(0L, 1L)
)

fun main() {
    var n = readLine()!!.toLong() - 1

    while (n > 0) {
        if (n % 2 == 1L) {
            result = matrixMultiply(arr, result)
        }
        arr = matrixMultiply(arr, arr)
        n /= 2
    }

    print((result[1][1] + result[1][0]) % MOD)
}

fun matrixMultiply(m1: Array<Array<Long>>, m2: Array<Array<Long>>): Array<Array<Long>> {
    val resultMatrix = Array(2) { Array(2) { 0L } }
    for (i in 0 until 2) {
        for (j in 0 until 2) {
            for (k in 0 until 2) {
                resultMatrix[i][j] += m1[i][k] * m2[k][j]
                resultMatrix[i][j] %= MOD
            }
        }
    }
    return resultMatrix
}