package baekjoon.silver.s1

fun main() = with(System.`in`.bufferedReader()) {
    val arr = BooleanArray(1000001) { true }
    arr[0] = false
    arr[1] = false
    for (i in 2 until arr.size) {
        if (arr[i]) {
            for (j in i * 2 until arr.size step i) {
                arr[j] = false
            }
        }
    }

    while (true) {
        val n = readLine().toInt()
        if (n == 0) break
        var left = 3
        var right = n - 3

        while (left <= right) {
            if (arr[left] && arr[right]) {
                println("$n = $left + $right")
                break
            }
            left += 2
            right -= 2
        }
    }
}