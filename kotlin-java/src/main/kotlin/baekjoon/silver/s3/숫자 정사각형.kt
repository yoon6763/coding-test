package baekjoon.silver.s3

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { readln().toCharArray() }
    var answer = 1
    for (i in arr.indices)
        for (j in arr[i].indices)
            for (k in 1 until minOf(n - i, m - j))
                if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j + k])
                    answer = maxOf(answer, k + 1)

    println(answer * answer)
}