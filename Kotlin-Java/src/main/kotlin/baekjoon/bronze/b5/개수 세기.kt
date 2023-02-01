package baekjoon.bronze.b5

import java.util.StringTokenizer

fun main() {
    val n = readLine()!!.toInt()
    val num = StringTokenizer(readLine()," ")
    val target = readLine()!!.toInt()
    var result = 0

    for(i in 0 until n) {
        if(num.nextToken().toInt() == target) result ++
    }
    println(result)
}