package baekjoon.bronze.b3

fun main() {
    readln()
    val arr = readln().split(" ")
    val sb = StringBuilder()
    sb.append(arr[0][0])

    for (i in 1 until arr.size) {
        val preSize = arr[i - 1].length
        if (arr[i].length < preSize) sb.append(" ")
        else sb.append(arr[i][preSize - 1])
    }

    println(sb.toString())
}