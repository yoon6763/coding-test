package baekjoon.platinum.p5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val lis = ArrayList<Int>()

    lis.add(Int.MIN_VALUE)

    val n = br.readLine().toInt()
    val arr = Array(n) { 0 }
    val idx = Array(n) { 0 }

    val st = StringTokenizer(br.readLine(), " ")
    for (i in 0 until n) arr[i] = st.nextToken().toInt()

    for (i in 0 until n) {
        if (lis[lis.size - 1] < arr[i]) {
            lis.add(arr[i])
            idx[i] = lis.size - 1
        } else {
            var left = 1
            var right = lis.size - 1

            while (left < right) {
                val mid = (left + right) / 2

                if (lis[mid] < arr[i]) left = mid + 1
                else right = mid
            }
            lis[right] = arr[i]
            idx[i] = right
        }
    }

    println(lis.size - 1)

    var index = lis.size - 1
    val stack = Stack<Int>()

    for (i in n - 1 downTo 0) {
        if (idx[i] == index) {
            index--
            stack.push(arr[i])
        }
    }

    while (!stack.isEmpty()) {
        print("${stack.pop()} ")
    }
}


/*
6
10 20 10 30 20 50
 */