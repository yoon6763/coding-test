package baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val line = br.readLine().toCharArray()

    var cnt = 0
    var i = 0
    var pattern = 0

    while (i < m - 2) {

        if(line[i] == 'I' && line[i+1] == 'O' && line[i+2] == 'I'){
            pattern++

            if(pattern == n) {
                pattern--
                cnt++
            }

            i++
        } else {
            pattern = 0
        }
        i++
    }
    println(cnt)
}

/*
2
13
OOIOIOIOIIOII
 */