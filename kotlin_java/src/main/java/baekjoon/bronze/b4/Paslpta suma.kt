package baekjoon.bronze.b4

fun main() {
    val arr = List(10) { readln().toInt() }
    val sum = arr.sum()
    for (i in arr.indices) {
        if (sum - arr[i] == arr[i]) {
            println(arr[i])
            return
        }
    }
}