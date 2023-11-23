package baekjoon.bronze.b5

import java.lang.Exception

fun main() {
    var cnt = 0
    while (true) {
        try {
            readln()
            cnt++
        } catch (e:Exception) {
            break
        }
    }
    println(cnt)
}