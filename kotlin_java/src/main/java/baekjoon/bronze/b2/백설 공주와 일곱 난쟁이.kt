package baekjoon.bronze.b2

fun main() {
    val arr = Array(9) { readln().toInt() }
    val sum = arr.sum()
    for (i in 0 until 9) {
        for (j in i + 1 until 9) {
            if (i != j) {
                if (sum - arr[i] - arr[j] == 100) {
                    repeat(9) {
                        if (it != i && it != j) println(arr[it])
                    }
                    return
                }
            }
        }
    }
}