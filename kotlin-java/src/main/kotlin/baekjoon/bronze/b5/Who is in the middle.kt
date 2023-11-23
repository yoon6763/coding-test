package baekjoon.bronze.b5

fun main() {
    val arr = IntArray(3)
    repeat(3) {
        arr[it] = readLine()!!.toInt()
    }
    arr.sort()
    println(arr[1])
}