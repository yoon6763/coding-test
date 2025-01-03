package baekjoon.bronze.b2

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().toInt() }

    for (i in 1..m) {
        for (j in 1..<n) {
            if (arr[j - 1] % i > arr[j] % i) {
                val temp = arr[j - 1]
                arr[j - 1] = arr[j]
                arr[j] = temp
            }
        }
    }

    println(arr.joinToString("\n"))
}
