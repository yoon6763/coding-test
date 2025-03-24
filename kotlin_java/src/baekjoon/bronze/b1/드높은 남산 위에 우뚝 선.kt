package baekjoon.bronze.b1

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    var flag = false
    for (i in 1 until arr.size) {
        if (arr[i] == arr[i - 1]) {
            println("NO")
            return
        }
        if (arr[i] > arr[i - 1] && flag) {
            println("NO")
            return
        }
        if (arr[i] < arr[i - 1]) flag = true
    }

    println("YES")
}