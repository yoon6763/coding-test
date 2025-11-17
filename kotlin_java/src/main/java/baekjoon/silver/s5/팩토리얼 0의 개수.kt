package baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var five = 0

    for (i in 1..n) {
        var temp = i
        while(temp >= 5) {
            if(temp % 5 == 0){
                temp /= 5
                five++
            } else {
                break
            }
        }
    }
    println(five)
}