package baekjoon.bronze.b4

fun main() {
    val cnt = Array<Int>(26) {0}
    val line = readLine()!!
    for(c in line) cnt[c - 'a']++
    for(i in cnt)  print("$i ")
}