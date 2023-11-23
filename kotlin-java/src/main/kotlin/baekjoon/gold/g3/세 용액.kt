package baekjoon.gold.g3

import java.util.StringTokenizer
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = Array(n) { 0 }
    val st = StringTokenizer(readLine())
    repeat(n) {
        arr[it] = st.nextToken().toInt()
    }
    arr.sort()

    var min = Long.MAX_VALUE
    val resultArr = arrayOf(-1, -1, -1)

    for (m in 1 until n - 1) {
        var l = 0
        var r = n - 1

        while (l < r && l < m && m < r) {
            val sum = arr[l].toLong() + arr[m] + arr[r] // int 형일 경우 오버플로우 발생 가능성이 있으므로 long

            // 누가 더 0에 더 가깝냐를 비교해야 하기 때문에 절대값을 취해 비교
            if (abs(sum) < abs(min)) {
                resultArr[0] = arr[l]
                resultArr[1] = arr[m]
                resultArr[2] = arr[r]
                min = sum
            }

            if (sum < 0) {
                l++
            } else if (sum > 0) {
                r--
            } else {
                // sum == 0 case
                resultArr[0] = arr[l]
                resultArr[1] = arr[m]
                resultArr[2] = arr[r]
                min = 0
                break
            }
        }

        if (min == 0L) {
            break
        }
    }
    println("${resultArr[0]} ${resultArr[1]} ${resultArr[2]}")
}