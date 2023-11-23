package baekjoon.bronze.b2

fun main() {
    val arr = Array(5) { 0 }
    repeat(5) {
        arr[it] = readLine()!!.toInt()
    }

    println(arr.sum() / 5)
    println(arr.sortedArray()[2])
}