package baekjoon.gold.g4

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())

    val arr = Array(n) { 0L }
    repeat(n) {
        arr[it] = st.nextToken().toLong()
    }
    arr.sort()

    var cnt = 0

    repeat(n) { ptr ->
        var left = 0
        var right = n - 1

        while (left < right) {
            val sum = arr[left] + arr[right]

            if (sum == arr[ptr]) {
                // 투 포인터가 자기 자신을 포함하면 안됨
                if (left == ptr || right == ptr) {
                    if (left == ptr) left++
                    if (right == ptr) right--
                } else {
                    cnt++
                    break
                }

            } else if (sum < arr[ptr]) {
                left++
            } else {
                right--
            }
        }
    }

    println(cnt)
}