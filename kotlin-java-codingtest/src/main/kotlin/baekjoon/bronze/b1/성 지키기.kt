package baekjoon.bronze.b1

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { readln().toCharArray() }
    val verticalCheck = Array(n) { BooleanArray(m) { false } }
    val horizontalCheck = Array(n) { BooleanArray(m) { false } }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 'X') {
                for (k in 0 until n) verticalCheck[k][j] = true
                for (k in 0 until m) horizontalCheck[i][k] = true
            }
        }
    }

    var count = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!verticalCheck[i][j] && !horizontalCheck[i][j]) {
                count++
                for (k in 0 until n) verticalCheck[k][j] = true
                for (k in 0 until m) horizontalCheck[i][k] = true
            }
        }
    }

    println(count + verticalCheck[0].count { !it } + horizontalCheck.count { !it[0] })
}