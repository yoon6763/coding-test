package baekjoon.silver.s3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n) { readLine().toInt() }.sortedDescending()
    var answer = -1

    for (i in 0..<n - 2) {
        if (arr[i] < arr[i + 1] + arr[i + 2]) {
            answer = arr[i] + arr[i + 1] + arr[i + 2]
            break
        }
    }

    print(answer)
}