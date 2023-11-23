package baekjoon.silver.s4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    var st = StringTokenizer(br.readLine(), " ")
    val arr1 = IntArray(n) { 0 }

    for(i in 0 until n) {
        arr1[i] = st.nextToken().toInt()
    }
    arr1.sort()

    val n2 = br.readLine().toInt()
    st = StringTokenizer(br.readLine(), " ")
    val arr2 = IntArray(n2) { 0 }

    for(i in 0 until n2) {
        arr2[i] = st.nextToken().toInt()
    }

    val sb = StringBuilder()

    for (i in arr2) {
        sb.append(upperBound(arr1, i) - lowerBound(arr1, i)).append(" ")
    }

    print(sb)
}

fun lowerBound(arr: IntArray, target: Int): Int {
    var lo = 0
    var hi = arr.size

    while (lo < hi) {
        val mid = (hi + lo) / 2

        if (target <= arr[mid]) {
            hi = mid
        } else {
            lo = mid + 1
        }
    }

    return lo
}

fun upperBound(arr: IntArray, target: Int): Int {
    var lo = 0
    var hi = arr.size

    while (lo < hi) {
        val mid = (hi + lo) / 2

        if (target < arr[mid]) {
            hi = mid
        } else {
            lo = mid + 1
        }
    }

    return lo
}


/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
 */