package baekjoon.bronze.b1

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val str = readln()

    for (i in 0..<n - 4) {

        var flag = true
        for (j in i + 1..i + 4) {
            if (abs(str[j] - str[j - 1]) != 1) {
                flag = false
                break
            }
        }

        if (flag) {
            println("YES")
            return
        }
    }
    println("NO")
}