package baekjoon.bronze.b5

fun main() {
    repeat(2) {
        val arr = readln().split(" ").map { it.toInt() }
        println(arr[0] * 6 + arr[1] * 3 + arr[2] * 2 + arr[3] + arr[4] * 2)
    }
}
