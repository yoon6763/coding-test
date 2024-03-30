package baekjoon.bronze.b4

fun main() {
    val arr = Array(4) { readln().toInt() }
    println(if ((arr[0] == 8 || arr[0] == 9) && (arr[3] == 8 || arr[3] == 9) && (arr[1] == arr[2])) "ignore" else "answer")
}