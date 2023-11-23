package baekjoon.silver.s3


fun main() {
    val line = readLine()!!.split(" ")
    val height = line[0].toInt()
    val width = line[1].toInt()

    val arr = Array(height) { Array(width) { ' ' } }

    for (i in 0 until height) {
        val tempLine = readLine()!!
        for (j in 0 until width) {
            arr[i][j] = tempLine[j]
        }
    }

    var result = 0

    for (i in arr.indices) {
        var check = 0

        var idx = 0
        while (idx < arr[0].size) {
            if (arr[i][idx] == '|' && check != 0) {
                check = 0
                result++
            } else if (arr[i][idx] == '|' ) {
                check = 0
            } else {
                check++
            }
            idx++
        }
        if (arr[i][--idx] == '-') result++
    }

    for (i in 0 until arr[0].size) {
        var check = 0

        var idx = 0
        while (idx < arr.size) {
            if (arr[idx][i] == '-' && check != 0) {
                check = 0
                result++
            } else if (arr[idx][i] == '-') {
                check = 0
            } else {
                check++
            }
            idx++
        }
        if (arr[--idx][i] == '|') result++
    }

    println(result)
}

