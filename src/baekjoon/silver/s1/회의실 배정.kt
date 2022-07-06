package baekjoon.silver.s1

fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n) { Array(2) { 0 } }

    repeat(n) {
        val line = readLine()!!.split(" ")
        arr[it][0] = line[0].toInt()
        arr[it][1] = line[1].toInt()

    }

    arr.sortWith(compareBy<Array<Int>> { it[1] }.thenBy { it[0] })

    var time = arr[0][1]
    var cnt = 0

    for (i in 1 until arr.size) {
        if (time <= arr[i][0]) {
            time = arr[i][1]
            cnt++
        }
    }

    println(cnt + 1)
}