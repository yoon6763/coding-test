package baekjoon.bronze.b4

fun main() {
    readln()
    val str1 = readln()
    val str2 = readln()
    var cnt = 0
    for(i in str1.indices) {
        if(str1[i] != str2[i]) cnt++
    }
    println(cnt)
}