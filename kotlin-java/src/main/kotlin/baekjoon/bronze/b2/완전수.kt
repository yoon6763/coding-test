package baekjoon.bronze.b2

import java.util.*

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }

    for (i in arr.indices) {
        val list = LinkedList<Int>()
        for (j in 1..<arr[i]) {
            if (arr[i] % j == 0) {
                list.add(j)
            }
        }
        val sum = list.sum()
        if (sum == arr[i]) {
            println("Perfect")
        } else if (sum > arr[i]) {
            println("Abundant")
        } else {
            println("Deficient")
        }
    }
}
