package baekjoon.silver.s3

import kotlin.math.floor
import kotlin.math.sign

fun main() {
    val line = readLine()!!.split(" ")
    val height = line[0].toInt()
    val width = line[1].toInt()

    var arr = Array<Array<String>>(height) { Array<String>(width) { "" } }

    for (i in 0 until height) {
        var tempLine = readLine()!!.split("")
        for (j in 0 until width) {
            arr[i][j] = tempLine[j + 1] //코틀린의 경우 split("")할 경우 배열 양끝에 텅빈값이 들가서 j+1부터
        }
    }
    println(match(arr))
}

fun match(arr: Array<Array<String>>): Int {
    var result = 0

    for (i in 0 until arr.size) {
        var check = 0

        var idx = 0
        while (idx < arr[0].size) {
            if (arr[i][idx] == "|" && check != 0) {
                check = 0
                result++
            } else if (arr[i][idx] == "|") {
                check = 0
            } else {
                check++
            }
            idx++
        }
        if (arr[i][--idx] == "-")
            result++
    }

    for (i in 0 until arr[0].size) {
        var check = 0

        var idx = 0
        while (idx < arr.size) {
            if (arr[idx][i] == "-" && check != 0) {
                check = 0
                result++
            } else if (arr[idx][i] == "-") {
                check = 0
            } else {
                check++
            }
            idx++
        }
        if (arr[--idx][i] == "|")
            result++
    }

    return result
}
