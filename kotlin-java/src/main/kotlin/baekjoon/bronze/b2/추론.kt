package baekjoon.bronze.b2

fun main() {
    val arr = IntArray(readln().toInt()) { readln().toInt() }

    if (arr[2] - arr[1] == arr[1] - arr[0]) println(arr[arr.size - 1] + (arr[1] - arr[0]))
    else println(arr[arr.size - 1] * (arr[1] / arr[0]))
}
