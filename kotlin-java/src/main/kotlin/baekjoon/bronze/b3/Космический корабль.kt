package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val sum = arr.sum()

    for (i in 0..<n) {
        if (sum - arr[i] == arr[i]) {
            for (j in 0..<n) {
                if (i == j) continue
                print("${arr[j]} ")
            }
            println(arr[i])
            return
        }
    }
}