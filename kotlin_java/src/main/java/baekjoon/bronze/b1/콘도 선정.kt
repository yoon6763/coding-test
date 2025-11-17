package baekjoon.bronze.b1

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    class Condo(val distance: Int, val price: Int, var able: Boolean)

    val n = readLine().toInt()

    val arr = Array(n) {
        val st = StringTokenizer(readLine())
        Condo(st.nextToken().toInt(), st.nextToken().toInt(), true)
    }

    arr.sortBy { it.distance }

    for (i in arr.indices) {
        for (j in i + 1..<n) {
            if (arr[i].price <= arr[j].price) {
                arr[j].able = false
            } else {
                break
            }
        }
    }

    arr.sortBy { it.price }

    for (i in arr.indices) {
        for (j in i + 1..<n) {
            if (arr[i].distance <= arr[j].distance) {
                arr[j].able = false
            } else {
                break
            }
        }
    }

    println(arr.count { it.able })
}