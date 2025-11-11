package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n)
    repeat(n) {
        arr[readln().toInt() - 1] = it + 1
    }
    println(arr.joinToString("\n"))
}