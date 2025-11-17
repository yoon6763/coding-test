package goormlevel.lv2.`0 채우기`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val arr = Array(n) { readLine()!!.split(" ").map { it.toInt() } }

    var x = 0
    var y = 0

    find@ for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] == 0) {
                x = i
                y = j
                break@find
            }
        }
    }

    var sum = 0
    for (i in 0 until n) {
        sum += arr[x][i] + arr[i][y]
    }
    println(sum)
}