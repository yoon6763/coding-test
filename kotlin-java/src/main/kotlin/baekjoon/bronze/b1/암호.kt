package baekjoon.bronze.b1

fun main() {
    val m = readln().toInt()
    val str = readln()
    val n = str.length / m
    val arr = Array(n) { Array(m) { ' ' } }

    repeat(m * n) {
        val x = it / m
        var y = it % m
        if (x % 2 == 1) y = m - y - 1
        arr[x][y] = str[it]
    }

    for(i in 0 until m) {
        for(j in 0 until n) {
            print(arr[j][i])
        }
    }
}