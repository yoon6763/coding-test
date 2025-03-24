package baekjoon.bronze.b4

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    if (arr[0] + arr[2] == arr[1] || arr[0] + arr[1] == arr[2] || arr[1] + arr[2] == arr[0] ||
        arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]
    ) println("S") else println("N")
}